package com.h2y.util;

public class Pagination {
	// 总的记录数
		private long totalRows = 0;

		// 当前页面
		private int currentPage = 1;

		// 总的页面数
		private int totalPages = 1;

		// 每一页显示的记录数(可以通过set方法进行修改)
		private int perPageRows = 20;

		// 连接页面
		private String sFileName;

		public String getSFileName() {
			return sFileName;
		}

		public void setSFileName(String fileName) {
			sFileName = fileName;
		}

		public Pagination(long totalRows, int currentPage, int perPageRows) {
			this.perPageRows = perPageRows;
			this.totalRows = totalRows;
			this.totalPages = ((Integer.parseInt(String.valueOf(this.totalRows)) - 1) / this.perPageRows) + 1;
			if (this.currentPage > this.totalPages) {
				this.currentPage = 1;
			}else{
				this.currentPage = currentPage;
			}
		}

		public long getTotalRows() {
			return totalRows;
		}

		public void setTotalRows(long totalRows) {
			this.totalRows = totalRows;
			this.totalPages = ((Integer.parseInt(String.valueOf(this.totalRows)) - 1) / this.perPageRows) + 1;
		}

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}

		public int getTotalPages() {
			return totalPages;
		}

		public void setTotalPages(int totalPages) {
			this.totalPages = totalPages;
		}

		public int getPerPageRows() {
			return perPageRows;
		}

		public void setPerPageRows(int perPageRows) {
			this.perPageRows = perPageRows;
		}

		public String showPage() {
			String sFileName = this.getSFileName(); // 链接地址
			int pageNum = this.getTotalPages(); // 页数
			int maxPerPage = this.getPerPageRows(); // 每页数量
			int currentPage = this.getCurrentPage(); // 当前页
			String strUnit = "条"; // 计数单位

			String strTemp = null;

			// 如果当前页大于总页数则当前页等于总页数
			if (currentPage > pageNum) {
				currentPage = pageNum;
			}
			// strUrl=sFileName;\
			if (currentPage == 1) {
				strTemp = "首页 上一页&nbsp;";
			} else {
				strTemp = "<a href='" + sFileName + "&id=1'>首页</a>&nbsp;";
				strTemp = strTemp + "<a href='" + sFileName + "&page="
						+ (currentPage - 1) + "'>上一页</a>&nbsp;";
			}

			if (currentPage >= pageNum) {
				strTemp = strTemp + "下一页 尾页";
			} else {
				strTemp = strTemp + "<a href='" + sFileName + "&page="
						+ (currentPage + 1) + "'>下一页</a>&nbsp;";
				strTemp = strTemp + "<a href='" + sFileName + "&page=" + pageNum
						+ "'>尾页</a>";
			}
			strTemp = strTemp + "&nbsp;页次：<strong><font color=red>" + currentPage
					+ "</font>/" + pageNum + "</strong>页 ";
			strTemp = strTemp + "&nbsp;" + maxPerPage + "" + strUnit + "/页";

			if (pageNum > 30 && pageNum <= 50) {
				strTemp = strTemp
						+ "&nbsp;转到第：<select name ='page' size='1' onchange =\"javascript:window.location.href='"
						+ sFileName + "&page="
						+ "'+this.options[this.selectedIndex].value\">";
				for (int i = 1; i < pageNum + 1; i++) {
					strTemp = strTemp + "<option value='" + i + "'";
					if (currentPage == i) {
						strTemp = strTemp + " selected ";
					}
					strTemp = strTemp + ">" + i + "</option>";
					i = i + 2;
				}
				strTemp = strTemp + "</select>页&nbsp;&nbsp;";
			} else if (pageNum > 100 && pageNum <= 1000) {
				strTemp = strTemp
						+ "&nbsp;转到第：<select name ='page' size='1' onchange =\"javascript:window.location.href='"
						+ sFileName + "&page="
						+ "'+this.options[this.selectedIndex].value\">";
				for (int i = 1; i < pageNum + 1; i++) {
					strTemp = strTemp + "<option value='" + i + "'";
					if (currentPage == i) {
						strTemp = strTemp + " selected ";
					}
					strTemp = strTemp + ">" + i + "</option>";
					i = i + 9;
				}
				strTemp = strTemp + "</select>页&nbsp;&nbsp;";
			} else if (pageNum > 1000) {
				strTemp = strTemp
						+ "&nbsp;转到第：<select name ='page' size='1' onchange =\"javascript:window.location.href='"
						+ sFileName + "&page="
						+ "'+this.options[this.selectedIndex].value\">";
				for (int i = 1; i < pageNum + 1; i++) {
					strTemp = strTemp + "<option value='" + i + "'";
					if (currentPage == i) {
						strTemp = strTemp + " selected ";
					}
					strTemp = strTemp + ">" + i + "</option>";
					i = i + 99;
				}
				strTemp = strTemp + "</select>页&nbsp;&nbsp;";
			} else {
				strTemp = strTemp
						+ "&nbsp;转到第：<select name='page' size='1' onchange=\"javascript:window.location.href='"
						+ sFileName + "&page="
						+ "'+this.options[this.selectedIndex].value;\">";
				for (int i = 1; i < pageNum + 1; i++) {
					strTemp = strTemp + "<option value='" + i + "'";
					if (currentPage == i) {
						strTemp = strTemp + " selected ";
					}
					strTemp = strTemp + ">" + i + "</option>";
				}
				strTemp = strTemp + "</select>页&nbsp;&nbsp;";
			}
			return strTemp;
		}

		public String showPage2() {
			String sFileName = this.getSFileName(); // 链接地址
			int pageNum = this.getTotalPages(); // 页数
			int currentPage = this.getCurrentPage(); // 当前页
			String strTemp = null;
			if (currentPage > pageNum) {
				currentPage = pageNum;
			}
			if (currentPage == 1) {
				strTemp = "<span class='prev-disabled'>上一页</span>";
			} else {
				strTemp = "<a class='prev' href='" + sFileName + "&page="
						+ (currentPage - 1) + "'>上一页</a>";
			}

			for (int i = 1; i < pageNum + 1; i++) {
				if (i == currentPage) {
					strTemp = strTemp + "<a href='" + sFileName + "&page=" + i
							+ "' class='current'>" + currentPage + "</a>";
				} else {
					strTemp = strTemp + "<a href='" + sFileName + "&page=" + i
							+ "'>" + i + "</a>";
				}
			}

			if (currentPage >= pageNum) {
				strTemp = strTemp + "<span class='prev-disabled'>下一页</span>";
			} else {
				strTemp = strTemp + "<a class='next' href='" + sFileName + "&page="
						+ (currentPage + 1) + "'>下一页</a>";
			}
			return strTemp;
		}

		public String showPage3() {
			String sFileName = this.getSFileName(); // 链接地址
			int pageNum = this.getTotalPages(); // 页数
			int currentPage = this.getCurrentPage(); // 当前页
			String strTemp = null;
			if (currentPage > pageNum) {
				currentPage = pageNum;
			}
			
			if (currentPage == 1) {
				strTemp = " <li class=\"previous disabled\"><a><span aria-hidden=\"true\">上一页</span></a></li>";
			} else {
				strTemp = " <li ><a href=\""+sFileName+ "&page="+(currentPage - 1)+"\" aria-label=\"Previous\"><span aria-hidden=\"true\">上一页</span></a></li>";
			}

			if (currentPage >= pageNum) {
				strTemp += " <li class=\"previous disabled\"><a><span aria-hidden=\"true\">下一页</span></a></li>";
			} else {
				strTemp += " <li ><a href=\""+sFileName+ "&page="+(currentPage + 1)+"\" aria-label=\"Previous\"><span aria-hidden=\"true\">下一页</span></a></li>";
			}
			
			strTemp+= "<li class=\"previous disabled\"><a>"+currentPage+"/"+pageNum+"页  共"+totalRows+"条</a></li>";
			strTemp = "<nav><ul class=\"pagination\">"+strTemp+"</ul></nav>";
			return strTemp;
		}
}
