package service;

import dao.PolicyDAO; // Assuming you have a PolicyDAO interface for data access
import model.Policy;
import model.User;

import java.util.List;

public class PolicyService {
    private PolicyDAO policyDAO;

    public PolicyService(PolicyDAO policyDAO) {
        this.policyDAO = policyDAO;
    }

    public List<Policy> getAllPolicies() {
        return policyDAO.getAllPolicies();
    }

    public Policy getPolicyById(int id) {
        return policyDAO.getPolicyById(id);
    }

    public void applyForPolicy(User user, Policy policy) {
    }

    public List<Policy> getPoliciesByUser(User user) {
      return null;
    }
}
