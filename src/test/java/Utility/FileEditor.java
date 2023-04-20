package Utility;

public class FileEditor {
	
	public static String replaceEntities( String src,String Order )
	{
		
		
		  src = replaceString( src, "OrderID{tab}", Order+"{tab}" );
		  

	  return src;
	}
	
	public static String retreive( String src,String Order )
	{
		
		
		  src = replaceString( src, Order+"{tab}", "OrderID{tab}"  );
		  

	  return src;
	}

	/**
	*  Replaces a string with an other string.
	*
	*  @param orig Original string.  Null is safe.
	*  @param src  The string to find.
	*  @param dest The string to replace <I>src</I> with.
	*  @return A string with the replacement done.
	*/
	public static final String replaceString( String orig, String src, String dest )
	{
	  if ( orig == null ) return null;
	  if ( src == null || dest == null ) throw new NullPointerException();
	  if ( src.length() == 0 ) return orig;

	  StringBuffer res = new StringBuffer(orig.length()+20); // Pure guesswork
	  int start = 0;
	  int end = 0;
	  int last = 0;

	  while ( (start = orig.indexOf(src,end)) != -1 )
	  {
	      res.append( orig.substring( last, start ) );
	      res.append( dest );
	      end  = start+src.length();
	      last = start+src.length();
	  }

	  res.append( orig.substring( end ) );

	  return res.toString();
	}

	/**
	*  Replaces a part of a string with a new String.
	*
	*  @param start Where in the original string the replacing should start.
	*  @param end Where the replacing should end.
	*  @param orig Original string.  Null is safe.
	*  @param text The new text to insert into the string.
	*  @return The string with the orig replaced with text.
	*/
	public static String replaceString( String orig, int start, int end, String text )
	{
	  if( orig == null ) return null;

	  StringBuffer buf = new StringBuffer(orig);

	  buf.replace( start, end, text );

	  return buf.toString();
	}

	/**
	*  Replaces a string with an other string. Case insensitive matching is used
	*
	*  @param orig Original string.  Null is safe.
	*  @param src  The string to find.
	*  @param dest The string to replace <I>src</I> with.
	*  @return A string with all instances of src replaced with dest.
	*/
	public static String replaceStringCaseUnsensitive( String orig, String src, String dest )
	{
	  if( orig == null ) return null;

	  StringBuffer res = new StringBuffer();
	  int start        = 0;
	  int end          = 0;
	  int last         = 0;
	  
	  String origCaseUnsn = orig.toLowerCase();
	  String srcCaseUnsn = src.toLowerCase();

	  while( (start = origCaseUnsn.indexOf(srcCaseUnsn, end)) != -1 )
	  {
	      res.append( orig.substring( last, start ) );
	      res.append( dest );
	      end  = start+src.length();
	      last = start+src.length();
	  }

	  res.append( orig.substring( end ) );

	  return res.toString();
	}

}
