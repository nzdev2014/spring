package nz.co.s3m.clientside.dao;

import java.util.ArrayList;

import nz.co.s3m.clientside.vo.ClientSideVO;

public interface ClientSideDAO {
	
	public ArrayList<ClientSideVO> getClientSideList();
	public ClientSideVO getClientSideDetail(int bbsno);
	public int insertClientSide(ClientSideVO vo);
	public int updateClientSideOrders(int ref_no, int ref_step); // for hierarchical insert
	public int updateClientSide(ClientSideVO vo);
	public int deleteClientSide(int bbsno);
	public Integer totalClientSideLists();

}
