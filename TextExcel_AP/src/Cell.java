public class Cell {
	public Cell(){
	}
	public class Cell {
		public Cell(){
		}
		public void setInputVal(String input){
			String cellType=parseInput(input);
			if (cellType.equals("StringCell")){
				StringCell strCell = new StringCell(input);
			}
		}
		public String getInputVal(){
			
		}
		public String getPrintVal(){
		}
		private String parseInput(String input){
//			if(input.matches("\\D"))
				return "StringCell";
		}
	}
}