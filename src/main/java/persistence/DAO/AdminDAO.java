package persistence.DAO;

import org.apache.ibatis.session.SqlSession;
import persistence.PooledDataSource;
import persistence.dto.AdminDTO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import static persistence.MyBatisConnectionFactory.sqlSessionFactory;

public class AdminDAO {
    private final DataSource ds = PooledDataSource.getDataSource();
    private Scanner sc = new Scanner(System.in);
    private Connection conn;

    public AdminDAO(Connection conn){
        this.conn = conn;
    }

    public List<AdminDTO> findAdmin(){
        List<AdminDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.AdminMapper.selectAll");
        } finally {
            session.close();
        }
        return list;
    }
    public int insertAdmin(AdminDTO dto){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            int count = session.insert("mapper.AdminMapper.insert", dto);
            session.commit();
            return count;

        } finally {
            session.close();
        }
    }


    public int updateAdmin(AdminDTO dto){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            int count = session.update("mapper.AdminMapper.updateAll", dto);
            session.commit();

            return count;
        } finally {
            session.close();
        }
    }

    public int deleteAdmin(String id){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            int count = session.delete("mapper.AdminMapper.delete", id);
            session.commit();
            return count;
        } finally {
            session.close();
        }
    }



}
