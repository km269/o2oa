package com.x.base.core.project.server;

import java.util.concurrent.ConcurrentSkipListMap;

import org.apache.commons.lang3.BooleanUtils;

public class Nodes extends ConcurrentSkipListMap<String, Node> {

	private static final long serialVersionUID = 1915588470385018748L;

	public Nodes() throws Exception {
		super();
	}

	private ApplicationServers applicationServers;

	public ApplicationServers applicationServers() throws Exception {
		if (applicationServers == null) {
			synchronized (Nodes.class) {
				if (applicationServers == null) {
					applicationServers = new ApplicationServers(this);
				}
			}
		}
		return applicationServers;
	}

	private WebServers webServers;

	public WebServers webServers() throws Exception {
		if (webServers == null) {
			synchronized (Nodes.class) {
				if (webServers == null) {
					webServers = new WebServers(this);
				}
			}
		}
		return webServers;
	}

	private DataServers dataServers;

	public DataServers dataServers() throws Exception {
		if (dataServers == null) {
			synchronized (Nodes.class) {
				if (dataServers == null) {
					dataServers = new DataServers(this);
				}
			}
		}
		return dataServers;
	}

	private StorageServers storageServers;

	public StorageServers storageServers() throws Exception {
		if (storageServers == null) {
			synchronized (Nodes.class) {
				if (storageServers == null) {
					storageServers = new StorageServers(this);
				}
			}
		}
		return storageServers;
	}

	public String primaryCenterNode() {
		for (Entry<String, Node> en : this.entrySet()) {
			if (BooleanUtils.isTrue(en.getValue().getIsPrimaryCenter())) {
				return en.getKey();
			}
		}
		return null;
	}
}
