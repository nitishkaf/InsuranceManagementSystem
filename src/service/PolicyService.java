package service;

import dao.PolicyDAO;
import model.Policy;
import model.User;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Policy> getPoliciesByUser(User user) {
        return policyDAO.getAllPolicies().stream()
                .filter(policy -> policy.getUserId() == user.getUid())
                .collect(Collectors.toList());
    }

    public void applyForPolicy(User user, Policy policy) {
        if (policy.isUserApplied(user.getUid())) {
            System.out.println("You have already applied for this policy.");
            return;
        }

        policy.applyPolicy(user.getUid());
        System.out.println("Applied for policy: " + policy.getName());

        policyDAO.updatePolicy(policy);
    }

}
