package dao;

import model.Policy;
import java.util.List;

public interface PolicyDAO {
    void addPolicy(Policy policy);
    Policy getPolicyById(int id);
    List<Policy> getAllPolicies();
    void updatePolicy(Policy policy);
    void deletePolicy(int id);
}
