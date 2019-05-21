package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    private Connection con;

    public ItemDAO() throws DAOException {
         // コンストラクター
         // このクラスが呼ばれると、DBコネクションを作る
        getConnection();
    }

    public List<ItemBean> findAll() throws DAOException {
        if(con == null) {
            getConnection();
        }
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "select * from item";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            List<ItemBean> list = new ArrayList<>();
            while(rs.next()) {
                int code = rs.getInt("code");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                ItemBean bean = new ItemBean(code, name, price);
                list.add(bean);
            }
            return list;
        } catch(Exception e) {
            e.printStackTrace();
            throw new DAOException(("レコードの取得に失敗しました。"));
        } finally {
            try{
                if(rs != null) rs.close();
                if(st != null) st.close();
                close();
            } catch(Exception e) {
                throw new DAOException("リソースからの解放に失敗しました。");

            }
        }
    }

    public List<ItemBean> sortPrice(boolean isAscending) throws DAOException {
        if(con == null) {
            getConnection();
        }
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql;
            if(isAscending) {
                sql = "select * from item order by price";
            } else {
                sql = "select * from item order by price desc";
            }
            st = con.prepareStatement(sql);
            rs =st.executeQuery();
            List<ItemBean> list = new ArrayList<>();
            while (rs.next()) {
                int code = rs.getInt("code");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                ItemBean bean =  new ItemBean(code, name, price);
                list.add(bean);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("レコードの操作に失敗しました");
        }finally {
            try {
                if(rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                close();
            } catch (Exception e) {
                throw new DAOException("リソースの解放に失敗しました");
            }
        }
    }

    public List<ItemBean> findByPrice(int lePrice) throws DAOException {
        if(con == null) {
            getConnection();
        }
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "select * from item where price <= ?";
            st = con.prepareStatement(sql);
            st.setInt(1, lePrice);
            rs = st.executeQuery();
            List<ItemBean> list = new ArrayList<>();
            while(rs.next()) {
                int code = rs.getInt("code");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                ItemBean bean =  new ItemBean(code, name, price);
                list.add(bean);
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("レコードの操作に失敗");
        }finally {
            try {
                if(rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                close();
            } catch (Exception e) {
                throw new DAOException("リソースの解放に失敗しました");
            }
        }
    }

    public int deleteByPrimaryKey(int key) throws DAOException {
        if(con == null) {
            getConnection();
        }
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "delete from item where code = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, key);
            int rows = st.executeUpdate();
            return rows;
        }catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("sipai");
        }finally {

        }
    }

    public int addItem(String name, int price) throws DAOException {
        if(con == null) {
            getConnection();
        }
        PreparedStatement st = null;
        try{
            String sql = "insert into item(name, price) values(?, ?)";
            st = con.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, price);
            int rows = st.executeUpdate();
            return rows;
        }catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("レコードの操作に失敗しました");
        }finally {
            try{
                if(st != null) {
                    st.close();
                }
                close();
            }catch (Exception e) {
                throw new DAOException("リソースの解放に失敗");
            }finally {
                try{
                    if(st != null) {
                        st.close();
                    }
                    close();
                }catch (Exception e) {
                    throw new DAOException("解放に失敗");
                }
            }
        }
    }


    private void getConnection() throws DAOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3314/sample2?user=root&password=rootpassword";
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            throw new DAOException("接続に失敗しました。");
        }
    }

    private void close() throws SQLException {
        // connectionをきる
        if(con != null) {
            con.close();
            con = null;
        }
    }
}
