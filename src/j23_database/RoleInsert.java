package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoleInsert {
	
	private DBConnectionMgr pool;  //  트래픽 관리 (접속대기자 창...)
	
	public RoleInsert() {
	
			pool = DBConnectionMgr.getInstance(); //싱글톤, 유일한 인스턴스(객체) , 컬렉션 List( Vector )
	}
	
	
	public int saveRole(String roleName) {
		
		int successCount = 0;
		
		/*
		 * 프리 커넥션 (free - Connection) 할때 쓰는 변수들 
		 */
		
		String sql = null;
		Connection con = null;            //db 연결
		PreparedStatement pstmt = null;   //db 실행
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			sql = "insert into role_mst values (0,?)";
			pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, roleName);  // 첫번째 ? < --- set 
			 
			successCount = pstmt.executeUpdate(); // 완성된 query문 pstmt가 들고있음
			
			int newKey = 0;
			
			rs = pstmt.getGeneratedKeys();  // 쿼리가 실행되면, 자동증가(auto increment) 키값을 들고 있음
			if(rs.next()) { // while 문 대신 If문 쓴 이유?  데이터가 하나라서..
				newKey = rs.getInt(1); // 1번열의 위치 
			}
			
			System.out.println(newKey !=0 ? "새로운 키값: " + newKey : "키가 생성되지 않음");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			pool.freeConnection(con, pstmt, rs);
		}
		
		return successCount;
	}
	
	public static void main(String[] args) {
		
		
		RoleInsert roleInsert = new RoleInsert();
		
		int successCount = roleInsert.saveRole("ROLE_TESTER");
		System.out.println("insert 성공 건수: " + successCount);
		
	}

}
