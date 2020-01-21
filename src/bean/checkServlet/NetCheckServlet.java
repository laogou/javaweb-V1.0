package bean.checkServlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.checkService.NetCheckService;
import common.NetG;

/**
 * 稽核servlet
 * @author 张志远
 *
 */
@SuppressWarnings("serial")
public class NetCheckServlet extends HttpServlet{

	/**
	 * 获得前台参数交给后台处理
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String checkU = (String)request.getSession().getAttribute("user");  //用户验证
		ArrayList<NetG> list = new ArrayList<NetG>();      //用于集体修改稽核情况
		NetG net = null;
		NetG cSearch = null;    //传递查询条件的
		int i;
		
		//要传给后台的参数
		int id;                      //net表单编号
		int type;                    //稽查后结果（1通过、0不通过）
		
		//连接页面的获取参数的名字
		String netId = "";
		String netType = "";

		//一共稽查的数目
		String s = "";
	    s = request.getParameter("iNum");
		i = Integer.parseInt(s);
		for(int j=1;j<=i;j++){
			net = new NetG();
			netId = "netId" + j;
			netType = "netType" + j;
			//netCheckInfo = "netCheckInfo" + j;
			
			id = Integer.parseInt(request.getParameter(netId));
			System.out.println(request.getParameter(netId));
			System.out.println("表单第几个数据");
			System.out.println(id);
			type = Integer.parseInt(request.getParameter(netType));
			System.out.println(request.getParameter(netType));
			System.out.println("表单数据的稽核状态");
			System.out.println(type);
			//checkInfo = request.getParameter(netCheckInfo);
			//checkInfo = new String(checkInfo.getBytes("ISO-8859-1"),"UTF-8");
			net.setNetserial(id);
			net.setNetType(type);
			//net.setNetCheckInfo(checkInfo);
			//net.setNetCheManager(checkU);
			list.add(net);
		}
		try {
			cSearch = (NetG) request.getSession().getAttribute("netSear");
		} catch (Exception e) {
		}
		NetCheckService cs = new NetCheckService();
		cs.doUpdate(list);
		//返回修改后的查询结果（一直保留上级查询条件）
		cs.doSearch(cSearch);
		request.getSession().setAttribute("checkList", cs.doSearch(cSearch));      //返回查询结果给jsp页面
		request.getRequestDispatcher("/check/net_check.jsp").forward(request, response);
	}
}
