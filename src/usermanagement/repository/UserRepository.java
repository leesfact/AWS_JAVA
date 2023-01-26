package usermanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import usermanagement.config.DBConnectionMgr;
import usermanagement.entity.RoleDtl;
import usermanagement.entity.RoleMst;
import usermanagement.entity.User;

/*
 * UserDao (data access object)
 * 
 */

public class UserRepository {
	
	
	private static UserRepository instance;
	
	public static UserRepository getIntance() {
		if(instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}
	
	private DBConnectionMgr pool;
	
	private UserRepository() {
		
		pool = DBConnectionMgr.getInstance();
	}
	
	
	public int saveUser(User user) {
		int successCount = 0;
		
		Connection con = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			
			String sql ="insert into user_mst values(0, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			
			successCount = pstmt.executeUpdate();
		    

			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				user.setUserId(rs.getInt(1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return successCount;
	}
	
	
	public int saveRoleDtl(RoleDtl roleDtl) {
		
		int successCount = 0;
		Connection con = null;            //db 연결
		PreparedStatement pstmt = null;   //db 실행
	
		
		try {
			con = pool.getConnection();
			String sql = "insert into role_dtl values (0,?,?)"; //rold_id , user_id
			pstmt = con.prepareStatement(sql); //,Statement.RETURN_GENERATED_KEYS <---다른 쪽에서 활용하면 쓰면됨
			pstmt.setInt(1, roleDtl.getRoleId());  // 첫번째 ? < --- set 
			pstmt.setInt(2, roleDtl.getUserId()); 
			successCount = pstmt.executeUpdate(); // 완성된 query문 pstmt가 들고있음
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			pool.freeConnection(con, pstmt);
		}
		
		return successCount;
	}
		
	
	public User findUserByUsername(String username) {
		
		
		User user = null;
		Connection con = null;  //연결
		PreparedStatement pstmt = null; //실행
		ResultSet rs = null;
		
	
		try {
			con = pool.getConnection();
			
			String sql = "select\r\n"
					+ "	   um.user_id,\r\n"
					+ "    um.username,\r\n"
					+ "    um.password,\r\n"
					+ "    um.name,\r\n"
					+ "    um.email,\r\n"
					+ "    rd.role_dtl_id,\r\n"
					+ "    rd.role_id,\r\n"
					+ "    rd.user_id,\r\n"
					+ "    rm.role_id,\r\n"
					+ "    rm.role_name\r\n"
					+ "from\r\n"
					+ "	   user_mst um\r\n"
					+ "    left outer join role_dtl rd on(rd.user_id = um.user_id)\r\n"
					+ "    left outer join role_mst rm on(rm.role_id = rd.role_id)\r\n"
					+ "    \r\n"
					+ "where\r\n"
					+ "	   username = ?;" ;
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, username);
			
			rs = pstmt.executeQuery(); //return to ResultSet
			
			List<RoleDtl> roleDtls = new ArrayList<>();
			int i = 0;
			while(rs.next()) {
				if(i == 0) {
				user =  User.builder()
						    .userId(rs.getInt(1))
						    .username(rs.getString(2))
						    .password(rs.getString(3))
						    .name(rs.getString(4))
						    .email(rs.getString(5))
						    .build();
				}
				RoleMst roleMst = RoleMst.builder()
						.roleId(rs.getInt(9))
						.roleName(rs.getNString(10))
						.build();
				
				RoleDtl roleDtl = RoleDtl.builder()
						.roleDtlId(rs.getInt(6))
						.roleId(rs.getInt(7))
						.userId(rs.getInt(8))
						.roleMst(roleMst)
						.build();
				roleDtls.add(roleDtl);
				i++;
			}
			if(user != null) {
			user.setRoleDtl(roleDtls);
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);	
		}
		return user;
	}
	



public User findUserByEmail(String email) {
	
	
	User user = null;
	Connection con = null;  //연결
	PreparedStatement pstmt = null; //실행
	ResultSet rs = null;
	

	
	
	try {
		con = pool.getConnection();
		
		String sql = "select\r\n"
				+ "	   um.user_id,\r\n"
				+ "    um.username,\r\n"
				+ "    um.password,\r\n"
				+ "    um.name,\r\n"
				+ "    um.email,\r\n"
				+ "    rd.role_dtl_id,\r\n"
				+ "    rd.role_id,\r\n"
				+ "    rd.user_id,\r\n"
				+ "    rm.role_id,\r\n"
				+ "    rm.role_name\r\n"
				+ "from\r\n"
				+ "	   user_mst um\r\n"
				+ "    left outer join role_dtl rd on(rd.user_id = um.user_id)\r\n"
				+ "    left outer join role_mst rm on(rm.role_id = rd.role_id)\r\n"
				+ "    \r\n"
				+ "where\r\n"
				+ "	   email = ?;" ;
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, email);
		
		rs = pstmt.executeQuery(); //return to ResultSet
		
		List<RoleDtl> roleDtls = new ArrayList<>();
		int i = 0;
		while(rs.next()) {
			if(i == 0) {
			user =  User.builder()
					    .userId(rs.getInt(1))
					    .username(rs.getString(2))
					    .password(rs.getString(3))
					    .name(rs.getString(4))
					    .email(rs.getString(5))
					    .build();
			}
			RoleMst roleMst = RoleMst.builder()
					.roleId(rs.getInt(9))
					.roleName(rs.getNString(10))
					.build();
			
			RoleDtl roleDtl = RoleDtl.builder()
					.roleDtlId(rs.getInt(6))
					.roleId(rs.getInt(7))
					.userId(rs.getInt(8))
					.roleMst(roleMst)
					.build();
			roleDtls.add(roleDtl);
			i++;
		}
		
		if(user != null) {
			user.setRoleDtl(roleDtls);
			}
			
	} catch (Exception e) {
	
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt, rs);	
	}
	return user;
	}
}
