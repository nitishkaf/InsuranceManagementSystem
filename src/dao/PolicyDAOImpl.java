package dao;

import model.Policy;
import java.util.ArrayList;
import java.util.List;

public class PolicyDAOImpl implements PolicyDAO {
    private List<Policy> policies = new ArrayList<>();

    @Override
    public void addPolicy(Policy policy) {
        policies.add(policy);
    }

    @Override
    public Policy getPolicyById(int id) {
        return policies.stream()
                .filter(policy -> policy.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Policy> getAllPolicies() {
        return new ArrayList<>(policies);
    }

    @Override
    public void updatePolicy(Policy policy) {
        for (int i = 0; i < policies.size(); i++) {
            if (policies.get(i).getId() == policy.getId()) {
                policies.set(i, policy);
                break;
            }
        }
    }

    @Override
    public void deletePolicy(int id) {
        policies.removeIf(policy -> policy.getId() == id);
    }

}
