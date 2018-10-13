package com.jeecg.demo.controller;
import com.jeecg.demo.entity.IndustryEntity;
import com.jeecg.demo.service.IndustryServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.ComboTree;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.easyui.ComboTreeModel;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;


/**   
 * @Title: Controller  
 * @Description: 行业
 * @author onlineGenerator
 * @date 2018-09-21 10:55:56
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/industryController")
public class IndustryController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(IndustryController.class);

	@Autowired
	private IndustryServiceI industryService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 行业列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/demo/industryList");
	}

	/**
	 * 父级DEMO下拉菜单
	 */
	@RequestMapping(params = "getComboTreeData")
	@ResponseBody
	public List<ComboTree> getComboTreeData(HttpServletRequest request, ComboTree comboTree) {
		CriteriaQuery cq = new CriteriaQuery(IndustryEntity.class);
		if (comboTree.getId() != null) {
			cq.eq("IndustryEntity.id", comboTree.getId());
		}
		if (comboTree.getId() == null) {
			cq.isNull("IndustryEntity");
		}
		cq.add();
		List<TSDepart> demoList = systemService.getListByCriteriaQuery(cq, false);
		List<ComboTree> comboTrees = new ArrayList<ComboTree>();
		ComboTreeModel comboTreeModel = new ComboTreeModel("id", "industryName", "industryIntroduction");
		comboTrees = systemService.ComboTree(demoList, comboTreeModel, null, false);
		return comboTrees;
	}
	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(IndustryEntity industry,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(IndustryEntity.class, dataGrid);
		if(StringUtil.isEmpty(industry.getId())){
			cq.isNull("parentId");
		}else{
			cq.eq("parentId", industry.getId());
			industry.setId(null);
		}
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, industry, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.industryService.getDataGridReturn(cq, true);
		TagUtil.treegrid(response, dataGrid);
	}
	
	/**
	 * 删除行业
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(IndustryEntity industry, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		industry = systemService.getEntity(IndustryEntity.class, industry.getId());
		message = "行业删除成功";
		try{
			industryService.delete(industry);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "行业删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除行业
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "行业删除成功";
		try{
			for(String id:ids.split(",")){
				IndustryEntity industry = systemService.getEntity(IndustryEntity.class, 
				id
				);
				industryService.delete(industry);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "行业删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加行业
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(IndustryEntity industry, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "行业添加成功";
		try{
			if(StringUtil.isEmpty(industry.getParentId())){
				industry.setParentId(null);
			}
			industryService.save(industry);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "行业添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新行业
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(IndustryEntity industry, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "行业更新成功";
		IndustryEntity t = industryService.get(IndustryEntity.class, industry.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(industry, t);
			if(StringUtil.isEmpty(t.getParentId())){
				t.setParentId(null);
			}
			industryService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "行业更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 行业新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(IndustryEntity industry, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(industry.getId())) {
			industry = industryService.getEntity(IndustryEntity.class, industry.getId());
			req.setAttribute("industryPage", industry);
		}
		return new ModelAndView("com/jeecg/demo/industry-add");
	}
	/**
	 * 行业编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(IndustryEntity industry, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(industry.getId())) {
			industry = industryService.getEntity(IndustryEntity.class, industry.getId());
			req.setAttribute("industryPage", industry);
		}
		return new ModelAndView("com/jeecg/demo/industry-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","industryController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(IndustryEntity industry,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(IndustryEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, industry, request.getParameterMap());
		List<IndustryEntity> industrys = this.industryService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"行业");
		modelMap.put(NormalExcelConstants.CLASS,IndustryEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("行业列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,industrys);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(IndustryEntity industry,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"行业");
    	modelMap.put(NormalExcelConstants.CLASS,IndustryEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("行业列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<IndustryEntity> listIndustryEntitys = ExcelImportUtil.importExcel(file.getInputStream(),IndustryEntity.class,params);
				for (IndustryEntity industry : listIndustryEntitys) {
					industryService.save(industry);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(e.getMessage());
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	
}
