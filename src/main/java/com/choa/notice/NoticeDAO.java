package com.choa.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.choa.util.DBConnect;
import com.choa.util.RowMaker;

@Repository //NoticeDAO noticeDAO = new NoticeDAO(); 인거야
public class NoticeDAO {
	
	@Inject //바로 주입
	private DataSource dataSource;

	public List<NoticeDTO> noticeList(RowMaker rowMaker) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<NoticeDTO> ar  = new ArrayList<NoticeDTO>();
		
		String sql = "select * from"
				+ "(select rownum R, N.* from"
				+ "(select * from notice order by num desc) N)"
				+ "where R between ? and ?";
		
			pst = con.prepareStatement(sql);
			pst.setInt(1, rowMaker.getStartRow());
			pst.setInt(2, rowMaker.getLastRow());
			
			rs = pst.executeQuery();
			
			while(rs.next()){
				NoticeDTO ndto = new NoticeDTO();
				ndto.setNum(rs.getInt("num"));
				ndto.setWriter(rs.getString("writer"));
				ndto.setTitle(rs.getString("title"));
				ndto.setContents(rs.getString("contents"));
				ndto.setReg_date(rs.getDate("reg_date"));
				ndto.setHit(rs.getInt("hit"));
				ar.add(ndto);
			}
			
			DBConnect.disConnect(rs, pst, con);
		
		return ar;
	}
	
	public NoticeDTO noticeView(int num) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		NoticeDTO ndto = null;
		
		String sql = "select * from notice where num=?";
		pst = con.prepareStatement(sql);
		pst.setInt(1, num);
		
		rs = pst.executeQuery();
		
		if(rs.next()){
			ndto = new NoticeDTO();
			ndto.setNum(rs.getInt("num"));
			ndto.setWriter(rs.getString("writer"));
			ndto.setTitle(rs.getString("title"));
			ndto.setContents(rs.getString("contents"));
			ndto.setReg_date(rs.getDate("reg_date"));
			ndto.setHit(rs.getInt("hit"));
		}
		
		DBConnect.disConnect(rs, pst, con);
		
		return ndto;
		
	}
	
	public int noticeDelete(int num) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pst = null;
		int result = 0;
		
		String sql = "delete from notice where num=?";
		
		pst = con.prepareStatement(sql);
		pst.setInt(1, num);
		
		result = pst.executeUpdate();
	
		DBConnect.disConnect(pst, con);
		
		return result;
		
	}
	
	public int noticeUpdate(NoticeDTO noticeDTO) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pst = null;
		int result = 0;
		
		String sql = "update notice set title=?, contents=? where num=?";
		
		pst = con.prepareStatement(sql);
		
		pst.setString(1, noticeDTO.getTitle());
		pst.setString(2, noticeDTO.getContents());
		pst.setInt(3, noticeDTO.getNum());
		
		result = pst.executeUpdate();
		
		DBConnect.disConnect(pst, con);
		
		return result;
		
	}
	
	public int noticeWrite(NoticeDTO noticeDTO)throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pst = null;
		int result = 0;
		
		String sql = "insert into notice values (notice_seq.nextval,?,?,?,sysdate,0)";
		
		pst = con.prepareStatement(sql);
		
		pst.setString(1, noticeDTO.getWriter());
		pst.setString(2, noticeDTO.getTitle());
		pst.setString(3, noticeDTO.getContents());
		
		result = pst.executeUpdate();
		
		DBConnect.disConnect(pst, con);
		
		return result;
		
	}
	
	public int noticeCount() throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql = "select nvl(count(num),0) from notice";
		
		pst = con.prepareStatement(sql);
		
		rs = pst.executeQuery();
		
		if(rs.next()){
			result = rs.getInt(1);
		}
		
		DBConnect.disConnect(rs, pst, con);
		
		return result;
	}
	
	
	
	
	
}