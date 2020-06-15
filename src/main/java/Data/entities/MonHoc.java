package Data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mon_hoc", schema = "hibernateexercise", catalog = "")
public class MonHoc {
    private String maMon;
    private String tenMon;

    @Id
    @Column(name = "MaMon")
    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    @Basic
    @Column(name = "TenMon")
    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonHoc monHoc = (MonHoc) o;
        return Objects.equals(maMon, monHoc.maMon) &&
                Objects.equals(tenMon, monHoc.tenMon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maMon, tenMon);
    }
}
