package peer.model.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {
	private int page;
	private int pageLimit;
	private int pageTotal;
	private int startPage;
	private int endPage;
	
	public Pagination() {
		pageLimit = 10;
	}
	public Pagination(int msgTotal) {
		page = 1;
		pageLimit = 10;
		pageTotal = (msgTotal%pageLimit == 0)? msgTotal/pageLimit:(msgTotal/pageLimit) +1;
		startPage = msgTotal - ((page-1) * pageLimit);
		endPage = startPage - pageLimit + 1;
	}
	public Pagination(int page, int msgTotal) {
		this.page = page;
		pageLimit = 10;
		pageTotal = (msgTotal%pageLimit == 0)? msgTotal/pageLimit:(msgTotal/pageLimit) +1;
		startPage = msgTotal - ((page-1) * pageLimit);
		endPage = startPage - pageLimit + 1;
	}

}
