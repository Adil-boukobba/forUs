package d3Soft.hisys.dao;

import java.util.List;

import d3Soft.hisys.model.City;

public interface CityDao {
    public void insert(City city);
    public void update(City city);
    public void delete(City city);
    public City byId(int id);
    public List<City> getAll();
}