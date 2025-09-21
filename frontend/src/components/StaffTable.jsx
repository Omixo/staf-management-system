import React, { useEffect, useState } from "react";
import { getAllStaff, deleteStaff, countStaff } from "../api/staffApi";

const StaffTable = () => {
  const [staffList, setStaffList] = useState([]);
  const [staffCount, setStaffCount] = useState(0);

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

  const handleEdit = (id) => {
    // Implement edit logic (e.g., open modal or navigate)
    alert(`Edit staff ${id}`);
  };

  const handleView = (id) => {
    // Implement view logic (e.g., open modal or navigate)
    alert(`View staff ${id}`);
  };

  return (
    <div className="max-w-5xl mx-auto p-6">
      <div className="flex items-center justify-between mb-6">
        <h2 className="text-xl font-semibold text-gray-800">Staff List</h2>
        <div className="bg-blue-100 text-blue-800 px-4 py-2 rounded shadow font-bold">
          Total Staff: {staffCount}
        </div>
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
                <td className="px-4 py-2">{staff.staffId}</td>
                <td className="px-4 py-2">{staff.fullName}</td>
                <td className="px-4 py-2">{staff.managerName}</td>
                <td className="px-4 py-2">{staff.departmentName}</td>
                <td className="px-4 py-2">{staff.annualSalary}</td>
                <td className="px-4 py-2 flex gap-2 justify-center">
                  <button
                    onClick={() => handleView(staff.staffNo)}
                    className="bg-green-500 hover:bg-green-600 text-white px-3 py-1 rounded transition"
                  >
                    View
                  </button>
                  <button
                    onClick={() => handleEdit(staff.staffNo)}
                    className="bg-yellow-400 hover:bg-yellow-500 text-white px-3 py-1 rounded transition"
                  >
                    Edit
                  </button>
                  <button
                    onClick={() => handleDelete(staff.staffNo)}
                    className="bg-red-500 hover:bg-red-600 text-white px-3 py-1 rounded transition"
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
            {staffList.length === 0 && (
              <tr>
                <td colSpan={6} className="px-4 py-6 text-center text-gray-400">
                  No staff found.
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default StaffTable;