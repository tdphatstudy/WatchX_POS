package DTO;

public class ThuongHieu {
    private int idThuongHieu;
    private String tenThuongHieu;

    public ThuongHieu(int idThuongHieu, String tenThuongHieu) {
        this.idThuongHieu = idThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
    }

    public ThuongHieu() {
    }

    public int getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(int idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }
    public Object[] toArray()
    {
        return new Object[] {idThuongHieu,tenThuongHieu};
    }

    @Override
    public String toString() {
        return "ThuongHieu{" +
                "idThuongHieu=" + idThuongHieu +
                ", tenThuongHieu='" + tenThuongHieu + '\'' +
                '}';
    }
}
