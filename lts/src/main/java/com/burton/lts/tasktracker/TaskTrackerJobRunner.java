package com.burton.lts.tasktracker;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.core.logger.Logger;
import com.github.ltsopensource.core.logger.LoggerFactory;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.logger.BizLogger;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.github.ltsopensource.tasktracker.runner.JobRunner;

/**
 * 执行任务
 *
 * @author Robert HG (254963746@qq.com) on 8/19/14.
 */
public class TaskTrackerJobRunner implements JobRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskTrackerJobRunner.class);

    @Override
    public Result run(JobContext jobContext) throws Throwable {
        try {
            // TODO 业务逻辑
            LOGGER.info("我要执行：" + jobContext.getJob());
            BizLogger bizLogger = jobContext.getBizLogger();
            // 会发送到 LTS (JobTracker上)
            bizLogger.info("测试，业务日志啊啊啊啊啊");

        } catch (Exception e) {
            LOGGER.info("Run job failed!", e);
            return new Result(Action.EXECUTE_LATER, e.getMessage());
        }
        return new Result(Action.EXECUTE_SUCCESS, "执行成功了，哈哈");
    }

}
