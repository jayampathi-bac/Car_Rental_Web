package lk.ijse.coursework.service.other;

import lk.ijse.coursework.entity.Customer;
import lk.ijse.coursework.repo.CustomerRepo;
import lk.ijse.coursework.service.IdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class IdGeneratorImpl implements IdGenerate {
    @Autowired
    CustomerRepo repo;
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
    }

