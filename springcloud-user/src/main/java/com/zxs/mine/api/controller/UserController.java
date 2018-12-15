package com.zxs.mine.api.controller;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxs.mine.api.dto.UserDto;
import com.zxs.mine.api.exception.MyException;
import com.zxs.mine.api.utils.ExcelUtiles;
import com.zxs.mine.api.utils.JwtUtil;
import com.zxs.mine.domain.User;
import com.zxs.mine.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/demo")
    public String demo (){
        return "test RestController...............";
    }


    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public HashMap login(@RequestBody User user) {
        HashMap map = new HashMap();

        String pwd =  DigestUtils.md5DigestAsHex(user.getPasswd().getBytes());
        user.setPasswd(pwd);

        if(userService.search(user).isEmpty()){
            map.put("msg","用户不存在");
            return  map;
        }

        String token = JwtUtil.generateToken(user.getCode());

        map.put("Bearer",token);
        return map ;

    }




    @ApiOperation("分页查询用户信息")
    @PostMapping(value = "/pageUser")
    public PageInfo<User> search (@RequestBody UserDto userDto,
                                  @RequestParam(value = "page", required = false, defaultValue="1") Integer pageNum,
                                  @RequestParam(value = "size", required = false, defaultValue="8") Integer pageSize
    ){


        System.out.println(userDto+"-----------------------------------------------");

        PageHelper.startPage(pageNum, pageSize);
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        List<User> list = userService.searchByCondition(user);
        PageInfo<User> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }



    @ApiOperation("通过id查询单个用户信息")
    @GetMapping(value = "/findById/{id}")
    public User findById (@PathVariable("id")int id ){
        return userService.findById(id);
    }


    /**
     * 导出用户信息到excel
     * @param response
     */
    @ApiOperation("导出用户信息到excel")
        @GetMapping("/batchExport2excel")
        public void export(@RequestParam String ids,HttpServletResponse response) {
            System.out.println(1);
//        模拟从数据库获取需要导出的数据
            List<User> personList = userService.findByIds(ids);
//         导出操作
        ExcelUtiles.exportExcel(personList, "用户列表", "users", User.class, "用户表数据.xls", response);

    }


    /**
     * 导出全部外协顾问基本信息
     * @return
     */
//    @Permission(level = ResourceLevel.SITE)
//    @ApiOperation("查询全部外协顾问基本信息")
//    @GetMapping("/export")
//    public void  export(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("外协顾问基本信息", df.format(new Date()), "外协顾问基本信息"),OcmsResumeDTO.class,ocmsResumeService.listAll());
//        response.setContentType("text/html");
//        response.setHeader("Content-disposition", "attachment;filename=createList.xls");
//        response.flushBuffer();
//        workbook.write(response.getOutputStream());
//    }


//    @Permission(level = ResourceLevel.SITE)
//    @ApiOperation("导入用户信息")
//    @PostMapping("/import")
//    public void  importFromExcel(@RequestParam(value="file") MultipartFile multfile) throws  Exception{
//        String fileName = multfile.getOriginalFilename();
//        ImportParams params = new ImportParams();
//        params.setHeadRows(1);
//        String dir = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//        String filePath = dir + UUID.randomUUID() + "-"+ fileName ;
//        File file = new File(filePath);
//        multfile.transferTo(file);
//        List<UserDto> list = ExcelImportUtil.importExcel(file ,UserDto.class, params);
//
//        for(int i=0;i<list.size(); i++){
//            UserDto userDto = (UserDto)list.get(i) ;
//            if(checkRow(userDto)){
//                userService.create(userDto);
//            }else{
//
//            }
//
//        }
//
//        if(file.exists()&&file.isFile()){
//            file.delete();
//            System.out.println("文件删除成功" );
//        }else {
//            System.out.println("文件删除失败" );
//        }
//    }

    private boolean checkRow(UserDto userDto) {
        return false;
    }

    /**
     * 从excel导入到数据库
     * @param file
     */
    @ApiOperation("从excel导入到数据库")
    @PostMapping("/batchImportByExcel")
    public void importExcel(@RequestParam("file") MultipartFile file) {
        ImportParams importParams = new ImportParams();
        // 数据处理
        importParams.setHeadRows(1);
        importParams.setTitleRows(1);
        // 需要验证
        importParams.setNeedVerfiy(true);

        try {
            ExcelImportResult<User> result =
                    ExcelImportUtil.importExcelMore(file.getInputStream(), User.class,importParams);

            List<User> successList = result.getList();
            userService.saveList(successList);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("根据id数组批量删除用户信息")
    @PostMapping(value = "/removeUserByIds")
    public int removeUser (@RequestBody String ids ){
        if("".equals(ids) || ids==null){
            return 0;
        }

        String[] idArray = ids.replace("[","").replace("]","").split(",");

        return userService.removeByIds(idArray);
    }

    @ApiOperation("更新用户信息")
    @PostMapping(value = "/update")
    public int update (@RequestBody User user ){
        if("".equals(user.getId())){
            return 0;
        }


        return userService.updateUser(user);
    }


    @ApiOperation("添加用户信息")
    @PostMapping(value = "/add")
    public int add (@RequestBody User user ){
        if(user==null){
            return 0;
        }


        return userService.create(user);
    }


    @ApiOperation("获取空用户信息表单模板")
    @GetMapping(value = "/getBlankUser")
    public User getBlankUser (){
        User user=new User();
//        user.setId(123);
        return user;
    }


    @ApiOperation("上传文件")
    @PostMapping(value = "/uploadFile")
    public String uploadFile (@RequestParam("file") MultipartFile file , HttpServletRequest request){
        String file_path = "";

        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
         String url = "/upload/";
         String savePath = request.getServletContext().getRealPath(url);
         File dir = new File(savePath);
         if (!dir.exists() && !dir.isDirectory()) {
            System.out.println("目录不存在，需要创建");
            //创建目录
            dir.mkdirs();
         }

         String saveName = UUID.randomUUID() + "-"+ file.getOriginalFilename() ;
         String fpath = savePath + saveName;
         File f = new File(fpath);
         //f.createNewFile();

//        String fileName = file.getOriginalFilename();
//        String dir = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//        String filePath = dir + "/upload/"+ UUID.randomUUID() + "-"+ fileName ;
//        File f = new File(filePath);


        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            file_path = f.getCanonicalPath() ;
        }catch (Exception e){

        }


        url += saveName;
        System.out.println(url);

        return url;
    }

    //返回视图
    @RequestMapping(value = "/greeting")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("/greeting");
        mv.addObject("title","欢迎使用Thymeleaf!");

        return mv;
    }

    @RequestMapping("/home")
    public String home() throws Exception {
        throw new MyException("101", "Sam 错误");
    }


}
