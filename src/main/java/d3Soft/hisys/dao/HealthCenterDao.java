package d3Soft.hisys.dao;

import java.util.List;

import d3Soft.hisys.model.HealthCenter;

public interface HealthCenterDao {
    public void insert(HealthCenter center);
    public void update(HealthCenter center);
    public void delete(HealthCenter center);
    public HealthCenter byId(int id);
    public List<HealthCenter> getAll();
}
