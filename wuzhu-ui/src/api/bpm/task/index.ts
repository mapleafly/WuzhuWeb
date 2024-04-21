import request from '@/config/axios'

export type TaskVO = {
  id: number
}

export const getTaskTodoPage = async (params: any) => {
  return await request.get({ url: '/bpm/task/todo-page', params })
}

export const getTaskDonePage = async (params: any) => {
  return await request.get({ url: '/bpm/task/done-page', params })
}

export const getTaskManagerPage = async (params: any) => {
  return await request.get({ url: '/bpm/task/manager-page', params })
}

export const approveTask = async (data: any) => {
  return await request.put({ url: '/bpm/task/approve', data })
}

export const rejectTask = async (data: any) => {
  return await request.put({ url: '/bpm/task/reject', data })
}

export const getTaskListByProcessInstanceId = async (processInstanceId: string) => {
  return await request.get({
    url: '/bpm/task/list-by-process-instance-id?processInstanceId=' + processInstanceId
  })
}

// 获取所有可回退的节点
export const getTaskListByReturn = async (id: string) => {
  return await request.get({ url: '/bpm/task/list-by-return', params: { id } })
}

// 回退
export const returnTask = async (data: any) => {
  return await request.put({ url: '/bpm/task/return', data })
}

// 委派
export const delegateTask = async (data: any) => {
  return await request.put({ url: '/bpm/task/delegate', data })
}

// 转派
export const transferTask = async (data: any) => {
  return await request.put({ url: '/bpm/task/transfer', data })
}

// 加签
export const signCreateTask = async (data: any) => {
  return await request.put({ url: '/bpm/task/create-sign', data })
}

// 减签
export const signDeleteTask = async (data: any) => {
  return await request.delete({ url: '/bpm/task/delete-sign', data })
}

// 获取减签任务列表
export const getChildrenTaskList = async (id: string) => {
  return await request.get({ url: '/bpm/task/list-by-parent-task-id?parentTaskId=' + id })
}
