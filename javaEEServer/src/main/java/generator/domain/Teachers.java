package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName teachers
 */
@TableName(value ="teachers")
@Data
public class Teachers implements Serializable {
    private Integer teacher_id;

    private String name;

    private Integer gender;

    private Date birth_date;

    private String email;

    private String fhone;

    private String address;

    private String title;

    private Date hire_date;

    private Integer salary;

    private String degree;

    private String major;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Teachers other = (Teachers) that;
        return (this.getTeacher_id() == null ? other.getTeacher_id() == null : this.getTeacher_id().equals(other.getTeacher_id()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getBirth_date() == null ? other.getBirth_date() == null : this.getBirth_date().equals(other.getBirth_date()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getFhone() == null ? other.getFhone() == null : this.getFhone().equals(other.getFhone()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getHire_date() == null ? other.getHire_date() == null : this.getHire_date().equals(other.getHire_date()))
            && (this.getSalary() == null ? other.getSalary() == null : this.getSalary().equals(other.getSalary()))
            && (this.getDegree() == null ? other.getDegree() == null : this.getDegree().equals(other.getDegree()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTeacher_id() == null) ? 0 : getTeacher_id().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirth_date() == null) ? 0 : getBirth_date().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getFhone() == null) ? 0 : getFhone().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getHire_date() == null) ? 0 : getHire_date().hashCode());
        result = prime * result + ((getSalary() == null) ? 0 : getSalary().hashCode());
        result = prime * result + ((getDegree() == null) ? 0 : getDegree().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teacher_id=").append(teacher_id);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", birth_date=").append(birth_date);
        sb.append(", email=").append(email);
        sb.append(", fhone=").append(fhone);
        sb.append(", address=").append(address);
        sb.append(", title=").append(title);
        sb.append(", hire_date=").append(hire_date);
        sb.append(", salary=").append(salary);
        sb.append(", degree=").append(degree);
        sb.append(", major=").append(major);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}