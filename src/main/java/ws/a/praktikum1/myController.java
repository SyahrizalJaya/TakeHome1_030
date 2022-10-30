/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.a.praktikum1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author ACER
 */
@Controller
public class myController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hai(
            @RequestParam(value = "varA") String isipertama,
            @RequestParam(value = "varB") String isikedua
    ){
        String rslt="";
        
        if(isipertama.equals("jaya")&& isikedua.equals("dia")){
            rslt = "boleh";
        }else if(isipertama.equals("jaya")&& isikedua.equals("kakak")){
            rslt = "keluarga";
        }else if(isipertama.equals("jaya")&& isikedua.equals("cwk")){
            rslt = "???????????";
        }else{
            rslt = "Isi Bang!!!";
        }
        
        return rslt; 
    }
    
    @RequestMapping("/nexthalaman")
    //@ResponseBody
    public String next(@RequestParam(value = "varA") String isipertama,
            @RequestParam(value = "varB") String isikedua,
            @RequestParam(value = "foto") MultipartFile isiketiga,
            Model kurir
            
    )throws IOException{  
        byte[] img = isiketiga.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink= "data:image/png;base64,".concat(base64Image);
        kurir.addAttribute("paket1", isipertama);
        kurir.addAttribute("paket2", isikedua);
        kurir.addAttribute("paket3", imglink);
        
        
        return "viewpage";
    }
    
}
