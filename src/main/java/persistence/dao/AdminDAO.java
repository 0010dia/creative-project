package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import persistence.PooledDataSource;
import persistence.dto.AdminDTO;
import persistence.dto.Apart_price_indicesDTO;
import persistence.dto.Apart_transactionDTO;

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

    public List<Apart_price_indicesDTO> find_apart_price_indices(){
        List<Apart_price_indicesDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.Apart_price_indicesMapper.selectAll");
        }finally {
            session.close();
        }
        return list;
    }

    public int insert_apart_price_indices(Apart_price_indicesDTO dto){
        SqlSession sesssion = sqlSessionFactory.openSession();
        try{
            int count = sesssion.insert("mapper.Apart_price_indicesMapper.insertPostOne", dto);
            sesssion.commit();
            return count;
        }finally {
            sesssion.close();
        }
    }

    public int update_apart_price_indices(Apart_price_indicesDTO dto){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            int count = session.update("mapper.Apart_price_indicesMapper.updatePostOne", dto);
            session.commit();
            return count;
        }finally {
            session.close();
        }
    }

    public int delete_apart_price_indices(String id){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            int count = session.delete("mapper.Apart_price_indicesMapper.deletePostOne", id);
            session.commit();
            return count;
        }finally {
            session.close();
        }
    }

    public List<Apart_transactionDTO> find_apart_transaction(){
        List<Apart_transactionDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.Apart_transactionMapper.selectAll");
        }finally {
            session.close();
        }
        return list;
    }

    public int insert_apart_transaction(Apart_transactionDTO dto){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            int count = session.insert("mapper.Apart_transactionMapper.insertPostOne", dto);
            session.commit();
            return count;
        }finally {
            session.close();
        }
    }

    public int update_apart_transaction(Apart_transactionDTO dto){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            int count = session.update("mapper.Apart_transactionMapper.updatePostOne", dto);
            session.commit();
            return count;
        }finally {
            session.close();
        }
    }

    public int delete_apart_transaction(String id){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            int count = session.update("mapper.Apart_transactionMapper.deletePostOne", id);
            session.commit();
            return count;
        }finally {
            session.close();
        }
    }


}
