package org.opensaml.liberty.binding.decoding;

import org.opensaml.common.binding.decoding.BasicURLComparator;
import org.opensaml.util.SimpleURLCanonicalizer;

public class MhvCustomURIComparator extends BasicURLComparator {
	
	private static final String SLASH = "/";
	private static final String MHV_PROXY_PATH = "/mhv-portal-web/";
	private static final String HTTPS = "https://";
	private static final String HTTP = "http://";

	@Override
	public boolean compare(String uri1, String uri2) {
		if (uri1 == null) {
            return uri2 == null;
        } else if (uri2 == null) {
            return uri1 == null;
        } else {
            String uri1Canon = SimpleURLCanonicalizer.canonicalize(normalizeUri(uri1));
            String uri2Canon = SimpleURLCanonicalizer.canonicalize(normalizeUri(uri2));
            if (isCaseInsensitive()) {
                return uri1Canon.equalsIgnoreCase(uri2Canon);
            } else {
                return uri1Canon.equals(uri2Canon);
            }
        }
	}
	
	private String normalizeUri(String uri) {
		
		// normalize the URI by removing the proxy path from the URI
		uri = uri.replaceAll(MHV_PROXY_PATH, SLASH);
		
		// normalize the URI by converting https:// to http://
		uri = uri.replaceAll(HTTPS, HTTP);
		
		return uri;
	}

}
