package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import j20_JSON.builder.User;

public class UserInsert {
	
	private DBConnectionMgr pool ;
	
	public UserInsert() {
		pool = DBConnectionMgr.getInstance(); //Singleton
	}
			
			
	public int saveUser(User user) {
		
		int successCount = 0;
		String sql = null;
		Connection connection = null; // 전역변수로 빼줌
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try { // why??? 
			 connection = pool.getConnection();  //workbench 에 접속
			 
			 sql = "insert into user_mst\r\n"
			 		+ "values (0,?,?,?,?)";
			 /*
			  * ? 쓰는 이유 : 어떤 값이 들어갈지 모르니
			  *  
			  */
			 
			 preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			 preparedStatement.setString(1, user.getUsername());  // 1 <-- '?' 의 순서
			 preparedStatement.setString(2, user.getPassword());
			 preparedStatement.setString(3, user.getName());
			 preparedStatement.setString(4, user.getEmail());
			 
			 successCount = preparedStatement.executeUpdate();  //insert, update, delete 명령 실행
			 
			 resultSet = preparedStatement.getGeneratedKeys(); //return ResultSet
			 
			 if(resultSet.next()) {
				 System.out.println("이번에 만들어진 user_id Key값: " + resultSet.getInt(1));
				 user.setUserId(resultSet.getInt(1)); //set
			 }
			 
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return successCount;  // 건수만 리턴
	}
	
	public int saveRoles(Map<String,Object> map) {
		
		
		int successCount = 0;
		String sql = null;
		Connection connection = null; // 전역변수로 빼줌
		PreparedStatement preparedStatement = null;
		
		
		
		try { // why??? 
			 connection = pool.getConnection();  //workbench 에 접속
			 
			 List<Integer> roles = (List<Integer>) map.get("roles"); // map은 key값이 명확
			 User user = (User)map.get("user");
			 
			 sql = "insert into role_dtl\r\n"
						+ "		 	values";
			 // map안에 들어 있는 List 크기만큼 반복 횟수
			 for(int i = 0; i<roles.size(); i++) {
					sql += "(0,?,?)";
					if(i< roles.size()-1) {
						sql += ",";
					}
				}
			 
			 preparedStatement = connection.prepareStatement(sql); //prepareStatement엔 완성된 query문을 전달해야함
			 
			 for(int i = 0; i<roles.size();i++) {
			 preparedStatement.setInt((i*2) + 1, roles.get(i) );  
			 preparedStatement.setInt((i*2) + 2, user.getUserId());
			 }
			 successCount = preparedStatement.executeUpdate();  //insert, update, delete 명령 실행
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		return successCount;
	}
	
	
	
	public static void main(String[] args) {
		
		UserInsert userInsert = new UserInsert(); //saveUser를 쓰기위한 객체 생성
		
		User user = User.builder()
				    .username("aaa")
				    .password("1234") 
				    .name("aaa")
				    .email("aaa@gmail.com")
				    .build();
		int successCount = userInsert.saveUser(user);
		
		System.out.println("query execution sucess: " + successCount + "건");
		System.out.println(user); 
		
		/*==============================================================*/
		/*
		 * 권한을 어떻게 주는지 보여주는 예
		 */
	
		List<Integer> roleIdList = new ArrayList<>();
		roleIdList.add(15); // 숫자가 무엇이든 중요치않음
		roleIdList.add(16);
		
		Map<String,Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roles", roleIdList);
		
		/*
		 * 데이터를 묶어두는 용도 
		 * List - 반복 용도
		 * 
		 * Map - 꼬리표를 달아놓는다... key를 선택하면 value가 따라나오는... 임시 entity(실재) 객체
		 * 
		 */
		
		
		System.out.println(map);
		
		successCount = userInsert.saveRoles(map);
		
		

	}

}
 