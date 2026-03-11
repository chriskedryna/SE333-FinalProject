from fastmcp import FastMCP

mcp = FastMCP("Demo 🚀")

@mcp.tool
def jacoco_parser(file_path: str):
    """Parse JaCoCo XML report and return coverage data as a dictionary."""
    import xml.etree.ElementTree as ET

    tree = ET.parse(file_path)
    root = tree.getroot()

    coverage_data = {}
    for package in root.findall(".//package"):
        package_name = package.get("name")
        for clazz in package.findall("class"):
            class_name = clazz.get("name")
            for method in clazz.findall("method"):
                method_name = method.get("name")
                # Extract coverage from LINE counter (or fall back to INSTRUCTION)
                counter = method.find('counter[@type="LINE"]')
                if counter is None:
                    counter = method.find('counter[@type="INSTRUCTION"]')
                if counter is None:
                    # If no counter found, skip this method
                    continue
                missed = counter.get("missed")
                covered = counter.get("covered")
                coverage_data[f"{package_name}.{class_name}.{method_name}"] = {
                    "missed": int(missed) if missed is not None else 0,
                    "covered": int(covered) if covered is not None else 0,
                }
    return coverage_data

@mcp.tool
def spotbugs_parser(file_path: str):
    """Parse SpotBugs XML report and return bug data as a dictionary."""
    import xml.etree.ElementTree as ET

    tree = ET.parse(file_path)
    root = tree.getroot()

    bug_data = {}
    for bug_instance in root.findall(".//BugInstance"):
        bug_type = bug_instance.get("type")
        
        # Safely get class name (required)
        class_elem = bug_instance.find("Class")
        if class_elem is None:
            continue
        class_name = class_elem.get("classname")
        
        # Safely get method name (optional)
        method_elem = bug_instance.find("Method")
        method_name = method_elem.get("name") if method_elem is not None else "unknown"
        
        bug_data[f"{class_name}.{method_name}"] = {
            "bug_type": bug_type,
            "priority": int(bug_instance.get("priority")), #type:ignore
        }
    return bug_data


if __name__ == "__main__":
    # IMPORTANT: Use SSE transport so VS Code can connect via URL.
    mcp.run(transport="sse")
