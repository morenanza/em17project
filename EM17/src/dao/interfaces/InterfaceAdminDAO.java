package dao.interfaces;

import model.Admin;

public interface InterfaceAdminDAO {
    public Admin getAdmin(String user, String password);
}
