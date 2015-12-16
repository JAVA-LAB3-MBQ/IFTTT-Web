package dao.impl;

import dao.IThisDao;
import domain.IfThisListenWeibo;
import domain.IfThisReceiveMail;
import domain.IfThisTime;

public class ThisDaoImpl implements IThisDao{
	public boolean addThis(IfThisListenWeibo this_) {
		// todo: add IfThisListWeibo condition to db
		return false;
	}
	
	public boolean addThis(IfThisTime this_) {
		// todo: add IfThisTime condition to db
		return false;
	}
	
	public boolean addThis(IfThisReceiveMail this_) {
		// todo: add IfThisReceiveMail condition to db
		return false;
	}
	
	public boolean removeThis(IfThisListenWeibo this_) {
		// todo: remove IfThisListenWeibo condition to db
		return false;
	}
	
	public boolean removeThis(IfThisTime this_) {
		// todo: remove IfThisTime condition to db
		return false;
	}
	
	public boolean removeThis(IfThisReceiveMail this_) {
		// todo: remove IfThisReveiveMail from db
		return false;
	}
}
