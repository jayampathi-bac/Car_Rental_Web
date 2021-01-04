package lk.ijse.coursework.service;

import java.io.IOException;

public interface IdGenerateService {
    String genarateId(String letter);
    String genarateCustomerId();
    byte [] getImage(String fileItem) throws IOException;
}
