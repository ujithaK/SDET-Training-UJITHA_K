import csv

def read_csv(input_file):
    """
    Reads the input CSV and returns a list of dictionaries.
    Expected columns: Name, Roll No, Marks
    """
    data = []
    try:
        with open(input_file, mode='r', newline='', encoding='utf-8') as file:
            reader = csv.DictReader(file)
            
            # Check for required columns
            required_cols = {"Name", "Roll No", "Marks"}
            if not required_cols.issubset(reader.fieldnames):
                raise ValueError("Invalid CSV format. Required columns missing.")

            for row in reader:
                try:
                    row["Marks"] = int(row["Marks"])  # convert marks to integer
                except ValueError:
                    raise ValueError(f"Invalid marks value for student: {row.get('Name')}")
                
                data.append(row)

    except FileNotFoundError:
        print(f"Error: File '{input_file}' not found.")
    except Exception as e:
        print("Error while reading CSV:", e)

    return data


# Function to process the data
def calculate_statistics(data):
    if not data:
        print("No data found.")
        return {}

    total_students = len(data)
    print("Total Students Count :", total_students)

    total_marks = sum(student["Marks"] for student in data)
    average_marks = total_marks / total_students
    print("Average Marks :", average_marks)

    highest_marks = max(student["Marks"] for student in data)
    print("Highest Marks :", highest_marks)

    toppers = [student["Name"] for student in data if student["Marks"] == highest_marks]
    print("Toppers :", ", ".join(toppers))

    summary = {
        "Average Marks": round(average_marks, 2),
        "Highest Marks": highest_marks,
        "Toppers": ", ".join(toppers)
    }

    return summary


# Function to write summary CSV
def write_summary(output_file, summary):
    try:
        with open(output_file, mode='w', newline='', encoding='utf-8') as file:
            writer = csv.writer(file)
            
            # Header
            writer.writerow(["Metric", "Value"])

            # Write summary
            for key, value in summary.items():
                writer.writerow([key, value])

        print("\nSummary written to", output_file)

    except Exception as e:
        print("Error while writing summary file:", e)


# Main execution
if __name__ == "__main__":
    input_file = "csv.csv"
    output_file = "student_summary.csv"

    data = read_csv(input_file)
    summary = calculate_statistics(data)

    if summary:
        write_summary(output_file, summary)


  