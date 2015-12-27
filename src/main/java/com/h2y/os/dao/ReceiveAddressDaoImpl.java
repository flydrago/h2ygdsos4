package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IReceiveAddressDaoR;
import com.h2y.os.dao.write.IReceiveAddressDaoW;
import com.h2y.os.entity.ReceiveAddress;

@Service("receiveAddressDao")
public class ReceiveAddressDaoImpl implements IReceiveAddressDao{
	
	@Autowired
	protected IReceiveAddressDaoR receiveAddressDaoR;
	
	@Autowired
	protected IReceiveAddressDaoW receiveAddressDaoW;

	public void add(ReceiveAddress receiveAddress) {
		receiveAddressDaoW.add(receiveAddress);
	}

	public void update(ReceiveAddress receiveAddress) {
		receiveAddressDaoW.update(receiveAddress);
	}

	public void updateUnDefaultByMemberId(String memberId) {
		receiveAddressDaoW.updateUnDefaultByMemberId(memberId);
	}

	public void deleteById(long id) {
		receiveAddressDaoW.deleteById(id);
	}

	public ReceiveAddress get(long id) {
		return receiveAddressDaoR.get(id);
	}

	public List<Map<String, Object>> getListMap(Map<String, Object> map) {
		return receiveAddressDaoR.getListMap(map);
	}

}
