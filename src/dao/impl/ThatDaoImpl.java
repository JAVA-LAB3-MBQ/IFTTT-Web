package dao.impl;

import dao.IThatDao;
import domain.ThenThatSendMail;
import domain.ThenThatSendWeibo;

public class ThatDaoImpl implements IThatDao {
	public boolean addThat(ThenThatSendWeibo that_) {
		// todo: add ThenThatSendWeibo to db
		
		return that_.add2Db();
	}
	public boolean addThat(ThenThatSendMail that_) {
		// todo: add ThenThatSendMail to db
		
		return that_.add2Db();
	}
	
	public boolean removeThat(ThenThatSendWeibo that_) {
		// todo: remove ThenThatSendWeibo from db
		
		return that_.removeFromDb();
	}
	public boolean removeThat(ThenThatSendMail that_) {
		// todo: remove ThenThatSendMail from db
		
		return that_.removeFromDb();
	}
	
}
