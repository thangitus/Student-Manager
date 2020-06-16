package Data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "lop_hoc", schema = "hibernateexercise", catalog = "")
public class LopHoc {
    private String maLop;


    @Id
    @Column(name = "MaLop")
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LopHoc lopHoc = (LopHoc) o;
        return Objects.equals(maLop, lopHoc.maLop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maLop);
    }
}
