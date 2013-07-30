import java.util.*;
import java.net.URI;
import java.net.URL;
import java.net.*;
import java.io.*;
import javax.swing.text.BadLocationException;

public class TryIterator {
	HashSet<String> visited = new HashSet<String>();
	
	public void launch(Set<String> urls){
		
		try {
			String firstUrl = "http://www.mrsneeze.com/";
			WebAnalyzer w = new WebAnalyzer(firstUrl);
			visited.add(firstUrl);
			Set<String> links = w.getLinks();
			urls.addAll(links);
			Iterator<String> it = urls.iterator();
			getUrls(urls,it);
			
		}catch(MalformedURLException ex){
			ex.printStackTrace();
		} catch(IOException	ex) {
			ex.printStackTrace();
		} catch(BadLocationException ex){
			ex.printStackTrace();
		}
		
	}
/* the loop isn't working. it doesn't move past checkVisited... 
see also problems in checkVisited*/
	public void getUrls(Set<String> urls, Iterator<String> urlsIt){
		try {
			while (urlsIt.hasNext()){
				String urlName = urlsIt.next();
				visited.add(urlName);
				WebAnalyzer wLoop = new WebAnalyzer(urlName);
				Set<String> urlLinks = wLoop.getLinks();
				addUrls(urls, urlLinks){
				urlsIt.next();
			}	
		
		}catch(MalformedURLException ex){
			ex.printStackTrace();
		} catch(IOException	ex) {
			ex.printStackTrace();
		} catch(BadLocationException ex){
			ex.printStackTrace();
		}	
				
				/*
				//peep(visited, i);
				
				
				//removeRepeats(linksLoop, urls);
				peep(linksLoop, i); */
				//i++;
				
			
			//Set<String> emails = w.getEmails();
			//spamlist.addAll(emails);
			//peep(spamlist);
	
	}
//don't need to remove repeats if add elements one by one
	
	public Set<String> addUrls(Set<String> urls, Set<String> urlLinks) throws UnsupportedOperationException {
		Iterator<String> urlLinksIt = urlLinks.iterator();
		while(urlsLinksIt.hasNext()){
			String urlToAdd = urlsLinksIt.next();
			urls.add(urlToAdd);
		}
		return urls;
			
	}	
		
	
	/*
	public Set<String> removeRepeats(Set<String> linksLoop, Set<String> urls){
	    Iterator<String> itr  = this.visited.iterator();
		while(itr.hasNext()) {
			String urlVisited = itr.next();
			Iterator<String> itr2 = linksLoop.iterator();
			while(itr2.hasNext()) {
			 	String toAdd = itr2.next();
				if (!toAdd.equals(urlVisited))	{
					urls.add(toAdd);
				}
			}
		}
		return urls;
	}
	
	*/
	public void peep(Set<String> set) {
		//System.out.println(set.size());
		
		Iterator<String> it = set.iterator();
		
		while (it.hasNext()){
			String element = it.next();
			System.out.println(element);
		}
		
	}	
	
	public static void main(String[] args){
		
		Set<String> urls = new HashSet<String>();
		Set<String> spamlist = new HashSet<String>();
		
		TryIterator run = new TryIterator();
		run.launch(urls);
/*		
		urls.add("www.bbk.ac.uk");
		urls.add("www.dcs.bbk.ac.uk");
		urls.add("moodle.bbk.ac.uk");
		System.out.println(urls.size());
		
		Iterator it = urls.iterator();
		while (it.hasNext()){.
			Object element = it.next();
			System.out.println(element + " ");
		}
*/		
	}
}	