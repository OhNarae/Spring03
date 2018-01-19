package vo;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import oracle.sql.DATE;

public class BoardVo {

	private int seq;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int cnt;
	private int root;
	private int step;
	private int indent;

	public int getRoot() {
		return root;
	}

	public void setRoot(int root) {
		this.root = root;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate.substring(0, 10);
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "BoardVo [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", cnt=" + cnt + ", root=" + root + ", step=" + step + ", indent=" + indent + "]";
	}

}
