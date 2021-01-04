package lk.ijse.coursework.service.other;

import lk.ijse.coursework.entity.Customer;
import lk.ijse.coursework.entity.User;
import lk.ijse.coursework.repo.CustomerRepo;
import lk.ijse.coursework.repo.UserRepo;
import lk.ijse.coursework.service.IdGenerateService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


@Service
@Transactional
public class IdGeneratorImplService implements IdGenerateService {
    @Autowired
    CustomerRepo repo;
    @Autowired
    UserRepo UserRepo;
    @Override
    public String genarateId(String letter) {
        String pid=null;
       if(letter.equalsIgnoreCase("C")) {
           List<User> user = UserRepo.findAllByUseridStartsWith("C");
//           List<Customer> a = Cusrepo.findAll();
           System.out.println("wsas");

           for (User c : user) {
               pid = c.getUserid();
               System.out.println(pid);
           }
           System.out.println(pid);
       }
        if(letter.equalsIgnoreCase("D")) {
            List<User> user = UserRepo.findAllByUseridStartsWith("D");
            System.out.println("Driver ID genetaing");

            for (User c : user) {
                pid = c.getUserid();
                System.out.println(pid+"drivers");
            }
        }
//        if(letter.equalsIgnoreCase("A")) {
//            List<Customer> a = repo.findAll();
//            System.out.println("wsas");
//
//            for (Customer c : a) {
//                pid = c.getUserid();
//                System.out.println(pid);
//            }
//        }

          String updatedPid="";
            if (pid !=null) {
                String[] temp = pid.split(letter);
                for (String s:temp) {
                    System.out.println(s);
                }
                int tempNumber = Integer.parseInt(temp[1]);
                System.out.println("----number--"+tempNumber);
                tempNumber++;

                if (tempNumber < 10) {
                    updatedPid=(letter+"00" + tempNumber);
                } else if (tempNumber < 100) {
                    updatedPid=(letter+"0" + tempNumber);
                } else {
                    updatedPid=(letter + tempNumber);
                }
            } else {
                updatedPid=letter+"001";
            }
           System.out.println(updatedPid);
            return updatedPid;
        }


    @Override
    public String genarateCustomerId() {
        List<Customer> a = repo.findAll();
        System.out.println("wsas");
        String pid=null;
        for(Customer c:a){
            pid=c.getUserid();
            System.out.println(pid);
        }

          String updatedPid="";
            if (pid !=null) {
                String[] temp = pid.split("C");
                int tempNumber = Integer.parseInt(temp[1]);
                tempNumber++;

                if (tempNumber < 10) {
                    updatedPid=("C00" + tempNumber);
                } else if (tempNumber < 100) {
                    updatedPid=("C0" + tempNumber);
                } else {
                    updatedPid=("C" + tempNumber);
                }
            } else {
                updatedPid="C001";
            }
           System.out.println(updatedPid);
            return updatedPid;
        }

    @Override
    public byte[] getImage(String fileItem) throws IOException {
            File file=new File(fileItem);
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile("file",
                    file.getName(), "image/png", IOUtils.toByteArray(input));
            return multipartFile.getBytes();
        }

}

