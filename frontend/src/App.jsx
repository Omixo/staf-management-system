import { useState } from 'react'
import './App.css'
import StaffTable from './components/StaffTable' // adjust path if needed

function App() {
  return (
    <div className="min-h-screen bg-gray-50">
      <h1 className="text-2xl font-bold text-center mt-8 mb-4">Staff Management</h1>
      <StaffTable />
    </div>
  )
}

export default App
