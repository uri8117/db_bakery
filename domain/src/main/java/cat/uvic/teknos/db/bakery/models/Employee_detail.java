package cat.uvic.teknos.db.bakery.models;

import java.sql.Date;

public interface Employee_detail {
    int getId();

    void setId(int id);

    Date getDate();

    void setDate(Date date);

    float getSalary();

    void setSalary(float salary);
}
