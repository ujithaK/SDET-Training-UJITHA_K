import pandas as pand
#   This function is to read the file 
def read_csv(input_file):
    try:
        data = pand.read_csv(input_file)
        return data
    except FileNotFoundError:
        print(f"Error: The file '{input_file}' was not found.")
    except pand.errors.EmptyDataError:
        print("Error: The CSV file is empty or invalid.")
    return None


#this is the function for processing the data and summary
def calculate_statistics(data): 
   total_Students=len(data)
   print("Total Students Count :",total_Students)

   Average_marks=data['Marks'].sum()/total_Students
   print("Average Marks :",Average_marks)

   highest_marks=data['Marks'].max()
   print("Highest Marks :",highest_marks)

   
   toppers=data.loc[data['Marks']==highest_marks,'Name']
   print('Toppers :', ','.join(toppers))


   summary = {
        "average_marks": int(Average_marks),
        "highest_marks": int(highest_marks),
        "toppers": ", ".join(toppers)
    }
   return summary

#this function is for writing summary
def  write_summary(output_file, summary):
  summary_df =pand.DataFrame([summary])
  summary_df.to_csv(output_file, index=False)
  finalData=pand.read_csv("student_summary.csv")
  print(finalData)


if __name__ == "__main__":
    input_file = "csv.csv"
    output_file = "student_summary.csv"

    data = read_csv(input_file)
    summary = calculate_statistics(data)

    if summary:
        write_summary(output_file, summary)