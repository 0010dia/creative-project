package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import persistence.dto.Apart_price_indicesDTO;
import persistence.dto.Apart_transactionDTO;
import persistence.dto.FavoriteDTO;
import persistence.dto.UserDTO;
import persistence.PooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import static persistence.MyBatisConnectionFactory.sqlSessionFactory;

public class UserDAO {
    private final DataSource ds = PooledDataSource.getDataSource();
    private Scanner sc = new Scanner(System.in);
    private Connection conn;

    public UserDAO(Connection conn){
        this.conn = conn;
    }

    public List<UserDTO> findUser(){
        List<UserDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.UserMapper.selectAll");
        } finally {
            session.close();
        }
        return list;
    }
    public int insertUser(UserDTO dto){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            int count = session.insert("mapper.UserMapper.insert", dto);
            session.commit();

            return count;
        } finally {
            session.close();
        }
    }

    public int updateUser(UserDTO dto){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            int count = session.update("mapper.UserMapper.updateAll", dto);
            session.commit();

            return count;
        } finally {
            session.close();
        }
    }

    public int deleteUser(String id){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            int count = session.delete("mapper.UserMapper.delete", id);
            session.commit();
            return count;
        } finally {
            session.close();
        }
    }

    public List<Apart_transactionDTO> find_apart_info(){
        List<Apart_transactionDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.Apart_transaction.selectAll");
        } finally {
            session.close();
        }
        return list;
    }

    public List<FavoriteDTO> findFavorite(UserDTO dto){
        List<FavoriteDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.Favorite.select", dto);
        }finally {
            session.close();
        }
        return list;
    }

    public int insertFavorite(FavoriteDTO dto){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            int count = session.insert("mapper.Favorite.insert", dto);
            session.commit();
            return count;
        }finally {
            session.close();
        }
    }

    public int deleteFavorite(String user_id){
        SqlSession session = sqlSessionFactory.openSession();
        try{
            int count = session.delete("mapper.Favorite.delete", user_id);
            session.commit();
            return count;
        }finally {
            session.close();
        }
    }

    public List<Apart_price_indicesDTO> findApart_price_indices(){
        List<Apart_price_indicesDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.Apart_price_indices.selectAll");
            session.commit();
        }finally{
            session.close();
        }
        return list;
    }


}
