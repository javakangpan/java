package proxy;

public class UserDaoProxy implements IUserDao {

	private IUserDao target;
	

	public UserDaoProxy(IUserDao target) {
		super();
		this.target = target;
	}


	@Override
	public void save() {

		target.save();
	}

}
