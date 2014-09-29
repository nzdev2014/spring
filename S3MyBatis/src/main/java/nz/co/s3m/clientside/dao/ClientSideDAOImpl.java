package nz.co.s3m.clientside.dao;

import java.util.ArrayList;

import nz.co.s3m.clientside.vo.ClientSideVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientSideDAOImpl implements ClientSideDAO {
	
	@Autowired
	private SqlSession sqlSession;		

	@Override
	public ArrayList<ClientSideVO> getClientSideList() {
		ArrayList<ClientSideVO> result = new ArrayList<ClientSideVO>();
		ClientSideDAO dao = sqlSession.getMapper(ClientSideDAO.class);
		result = dao.getClientSideList();
		return result;
	}

	@Override
	public ClientSideVO getClientSideDetail(int bbsno) {
		ClientSideDAO dao = sqlSession.getMapper(ClientSideDAO.class);
		return dao.getClientSideDetail(bbsno);
	}

	@Override
	public int insertClientSide(ClientSideVO vo) {
		ClientSideDAO dao = sqlSession.getMapper(ClientSideDAO.class);
		return dao.insertClientSide(vo);
	}

	@Override
	public int updateClientSideOrders(int ref_no, int ref_step) {
		ClientSideDAO dao = sqlSession.getMapper(ClientSideDAO.class);
		return dao.updateClientSideOrders(ref_no, ref_step);
	}

	@Override
	public int updateClientSide(ClientSideVO vo) {
		ClientSideDAO dao = sqlSession.getMapper(ClientSideDAO.class);
		return dao.updateClientSide(vo);
	}

	@Override
	public int deleteClientSide(int bbsno) {
		ClientSideDAO dao = sqlSession.getMapper(ClientSideDAO.class);
		return dao.deleteClientSide(bbsno);
	}

	@Override
	public Integer totalClientSideLists() {
		ClientSideDAO dao = sqlSession.getMapper(ClientSideDAO.class);
		return dao.totalClientSideLists();
	}

}
