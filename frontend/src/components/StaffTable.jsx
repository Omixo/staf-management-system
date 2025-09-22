import React, { useEffect, useState } from "react";
import { getAllStaff, deleteStaff, countStaff, searchStaff } from "../api/staffApi";

const StaffTable = () => {
  const [staffList, setStaffList] = useState([]);
  const [staffCount, setStaffCount] = useState(0);

  // Search states
  const [searchDept, setSearchDept] = useState("");
  const [searchManager, setSearchManager] = useState("");
  const [searchId, setSearchId] = useState("");

  useEffect(() => {
    fetchStaff();
    fetchCount();
  }, []);

  const fetchStaff = async () => {
    try {
      const res = await getAllStaff();
      setStaffList(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  const fetchCount = async () => {
    try {
      const res = await countStaff();
      setStaffCount(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteStaff(id);
      fetchStaff();
      fetchCount();
    } catch (err) {
      console.error(err);
    }
  };

  const handleEdit = (id) => alert(`Edit staff ${id}`);
  const handleView = (id) => alert(`View staff ${id}`);

  const handleSearch = async () => {
    try {
      const res = await searchStaff(searchDept, searchManager, searchId || null);
      setStaffList(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  const handleReset = () => {
    setSearchDept("");
    setSearchManager("");
    setSearchId("");
    fetchStaff();
  };

  return (
    <div className="max-w-5xl mx-auto p-6">
      <div className="flex items-center justify-between mb-6">
        <h2 className="text-xl font-semibold text-gray-800">Staff List</h2>
        <div className="bg-blue-100 text-blue-800 px-4 py-2 rounded shadow font-bold">
          Total Staff: {staffCount}
        </div>
      </div>

      {/* Search Filters */}
      <div className="flex gap-4 mb-4">
        <input
          type="text"
          placeholder="Department"
          value={searchDept}
          onChange={(e) => setSearchDept(e.target.value)}
          className="border px-2 py-1 rounded"
        />
        <input
          type="text"
          placeholder="Manager"
          value={searchManager}
          onChange={(e) => setSearchManager(e.target.value)}
          className="border px-2 py-1 rounded"
        />
        <input
          type="number"
          placeholder="Staff ID"
          value={searchId}
          onChange={(e) => setSearchId(e.target.value)}
          className="border px-2 py-1 rounded"
        />
        <button
          onClick={handleSearch}
          className="bg-blue-500 hover:bg-blue-600 text-white px-3 py-1 rounded"
        >
          Search
        </button>
        <button
          onClick={handleReset}
          className="bg-gray-400 hover:bg-gray-500 text-white px-3 py-1 rounded"
        >
          Reset
        </button>
      </div>

      <div className="bg-white rounded-lg shadow border border-gray-200 overflow-x-auto">
        <table className="min-w-full divide-y divide-gray-200">
          <thead className="bg-gray-50">
            <tr>
              <th className="px-4 py-2 text-left text-sm font-medium text-gray-700">
                ID
              </th>
              <th className="px-4 py-2 text-left text-sm font-medium text-gray-700">
                Full Name
              </th>
              <th className="px-4 py-2 text-left text-sm font-medium text-gray-700">
                Manager
              </th>
              <th className="px-4 py-2 text-left text-sm font-medium text-gray-700">
                Department
              </th>
              <th className="px-4 py-2 text-left text-sm font-medium text-gray-700">
                Salary
              </th>
              <th className="px-4 py-2 text-center text-sm font-medium text-gray-700">
                Actions
              </th>
            </tr>
          </thead>
         <tbody className="divide-y divide-gray-100">
  {staffList.map((staff) => (
    <tr key={staff.staffNo} className="hover:bg-gray-50">
      <td className="px-4 py-2">{staff.staffNo}</td>
      <td className="px-4 py-2">{staff.fullName}</td>
      <td className="px-4 py-2">{staff.managerName}</td>
      <td className="px-4 py-2">{staff.departmentName}</td>
      <td className="px-4 py-2">{staff.annualSalary}</td>
      <td className="px-4 py-2 flex gap-2 justify-center">
        ...
      </td>
    </tr>
  ))}
</tbody>

        </table>
      </div>
    </div>
  );
};

export default StaffTable;
