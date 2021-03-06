package com.x.okr.assemble.control.servlet.reportattachment;

import com.x.base.core.exception.PromptException;

class WorkReportQueryByIdException extends PromptException {

	private static final long serialVersionUID = 1859164370743532895L;

	WorkReportQueryByIdException( Throwable e, String id ) {
		super("查询指定ID的工作汇报信息时发生异常。ID：" + id, e );
	}
}
