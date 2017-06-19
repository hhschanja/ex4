package com.choa.freeboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnect;
import com.choa.util.RowMaker;

@Repository
public class FreeboardDAOImpl implements BoardDAO{
	
	@Inject
	private DataSource dataSource;
	
	@Override
	public List<BoardDTO> list(RowMaker rowMaker) throws Exception {
		// TODO Auto-generated method stub
		Connection con = dataSource.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<BoardDTO> ar  = new ArrayList<BoardDTO>();
		
		String sql = "select * from"
				+ "(select rownum R, N.* from"
				+ "(select * from freeboard order by ref desc, step asc) N)"
				+ "where R between ? and ?";
		
			pst = con.prepareStatement(sql);
			pst.setInt(1, rowMaker.getStartRow());
			pst.setInt(2, rowMaker.getLastRow());
			
			rs = pst.executeQuery();
			
			while(rs.next()){
				FreeboardDTO fdto = new FreeboardDTO();
				fdto.setNum(rs.getInt("num"));
				fdto.setWriter(rs.getString("writer"));
				fdto.setTitle(rs.getString("title"));
				fdto.setContents(rs.getString("contents"));
				fdto.setReg_date(rs.getDate("reg_date"));
				fdto.setHit(rs.getInt("hit"));
				fdto.setRef(rs.getInt("ref"));
				fdto.setRef(rs.getInt("step"));
				fdto.setRef(rs.getInt("depth"));
				ar.add(fdto);
			}
			
			DBConnect.disConnect(rs, pst, con);
		
		return ar;
	}

	@Override
	public int write(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = dataSource.getConnection();
		PreparedStatement pst = null;
		int result = 0;
		
		String sql = "insert into freeboard values (freeboard_seq.nextval,?,?,?,sysdate,0,freeboard_seq.currval,0,0)";
		
		pst = con.prepareStatement(sql);
		
		pst.setString(1, boardDTO.getWriter());
		pst.setString(2, boardDTO.getTitle());
		pst.setString(3, boardDTO.getContents());
		
		result = pst.executeUpdate();
		
		DBConnect.disConnect(pst, con);
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = dataSource.getConnection();
		PreparedStatement pst = null;
		int result = 0;
		FreeboardDTO fdto =  (FreeboardDTO)boardDTO;
		
		String sql = "update freeboard set title=?, contents=? where num=?";
		
		pst = con.prepareStatement(sql);
		
		pst.setString(1, fdto.getTitle());
		pst.setString(2, fdto.getContents());
		pst.setInt(3, fdto.getNum());
		
		result = pst.executeUpdate();
		
		DBConnect.disConnect(pst, con);
		
		return result;
	}

	@Override
	public BoardDTO view(int num) throws Exception {
		// TODO Auto-generated method stub
		Connection con = dataSource.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		FreeboardDTO fdto = null;
		
		String sql = "select * from freeboard where num=?";
		pst = con.prepareStatement(sql);
		pst.setInt(1, num);
		
		rs = pst.executeQuery();
		
		if(rs.next()){
			fdto = new FreeboardDTO();
			fdto.setNum(rs.getInt("num"));
			fdto.setWriter(rs.getString("writer"));
			fdto.setTitle(rs.getString("title"));
			fdto.setContents(rs.getString("contents"));
			fdto.setReg_date(rs.getDate("reg_date"));
			fdto.setHit(rs.getInt("hit"));
			fdto.setRef(rs.getInt("ref"));
			fdto.setRef(rs.getInt("step"));
			fdto.setRef(rs.getInt("depth"));
		}
		
		DBConnect.disConnect(rs, pst, con);
		
		return fdto;
	}

	@Override
	public int delete(int num) throws Exception {
		// TODO Auto-generated method stub
		Connection con = dataSource.getConnection();
		PreparedStatement pst = null;
		int result = 0;
		
		String sql = "delete from freeboard where num=?";
		
		pst = con.prepareStatement(sql);
		pst.setInt(1, num);
		
		result = pst.executeUpdate();
	
		DBConnect.disConnect(pst, con);
		
		return result;
	}

	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		Connection con = dataSource.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql = "select nvl(count(num),0) from freeboard";
		
		pst = con.prepareStatement(sql);
		
		rs = pst.executeQuery();
		
		if(rs.next()){
			result = rs.getInt(1);
		}
		
		DBConnect.disConnect(rs, pst, con);
		
		return result;
	}

	@Override
	public int hit(int num) throws Exception {

		// TODO Auto-generated method stub
				
		Connection con = dataSource.getConnection();
		PreparedStatement ps = null;
		int result = 0;
				
		String sql = "update freeboard set hit=hit+1 where num = ?";
				
		ps = con.prepareStatement(sql);
				
		ps.setInt(1, num);
				
		result = ps.executeUpdate();
				
		DBConnect.disConnect(ps, con);
				
		return result;
	}


	
	

}
