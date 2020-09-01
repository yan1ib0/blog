package com.Excalibur.blog.dao;

import com.Excalibur.blog.entity.Comment;
import com.Excalibur.blog.entity.CommentExample.Criteria;
import com.Excalibur.blog.entity.CommentExample.Criterion;
import com.Excalibur.blog.entity.CommentExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommentSqlProvider {

    public String countByExample(CommentExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("comment");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Comment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("comment");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getReplyName() != null) {
            sql.VALUES("reply_name", "#{replyName,jdbcType=VARCHAR}");
        }
        
        if (record.getReplyEmail() != null) {
            sql.VALUES("reply_email", "#{replyEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogId() != null) {
            sql.VALUES("blog_id", "#{blogId,jdbcType=INTEGER}");
        }
        
        if (record.getPublishDate() != null) {
            sql.VALUES("publish_date", "#{publishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuthorState() != null) {
            sql.VALUES("author_state", "#{authorState,jdbcType=TINYINT}");
        }
        
        if (record.getReplyState() != null) {
            sql.VALUES("reply_state", "#{replyState,jdbcType=TINYINT}");
        }
        
        if (record.getReplyContent() != null) {
            sql.VALUES("reply_content", "#{replyContent,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CommentExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("reply_name");
        sql.SELECT("reply_email");
        sql.SELECT("blog_id");
        sql.SELECT("publish_date");
        sql.SELECT("author_state");
        sql.SELECT("reply_state");
        sql.SELECT("reply_content");
        sql.SELECT("parent_id");
        sql.SELECT("create_time");
        sql.FROM("comment");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Comment record = (Comment) parameter.get("record");
        CommentExample example = (CommentExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("comment");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getReplyName() != null) {
            sql.SET("reply_name = #{record.replyName,jdbcType=VARCHAR}");
        }
        
        if (record.getReplyEmail() != null) {
            sql.SET("reply_email = #{record.replyEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogId() != null) {
            sql.SET("blog_id = #{record.blogId,jdbcType=INTEGER}");
        }
        
        if (record.getPublishDate() != null) {
            sql.SET("publish_date = #{record.publishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuthorState() != null) {
            sql.SET("author_state = #{record.authorState,jdbcType=TINYINT}");
        }
        
        if (record.getReplyState() != null) {
            sql.SET("reply_state = #{record.replyState,jdbcType=TINYINT}");
        }
        
        if (record.getReplyContent() != null) {
            sql.SET("reply_content = #{record.replyContent,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("comment");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("reply_name = #{record.replyName,jdbcType=VARCHAR}");
        sql.SET("reply_email = #{record.replyEmail,jdbcType=VARCHAR}");
        sql.SET("blog_id = #{record.blogId,jdbcType=INTEGER}");
        sql.SET("publish_date = #{record.publishDate,jdbcType=TIMESTAMP}");
        sql.SET("author_state = #{record.authorState,jdbcType=TINYINT}");
        sql.SET("reply_state = #{record.replyState,jdbcType=TINYINT}");
        sql.SET("reply_content = #{record.replyContent,jdbcType=VARCHAR}");
        sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=VARCHAR}");
        
        CommentExample example = (CommentExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Comment record) {
        SQL sql = new SQL();
        sql.UPDATE("comment");
        
        if (record.getReplyName() != null) {
            sql.SET("reply_name = #{replyName,jdbcType=VARCHAR}");
        }
        
        if (record.getReplyEmail() != null) {
            sql.SET("reply_email = #{replyEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogId() != null) {
            sql.SET("blog_id = #{blogId,jdbcType=INTEGER}");
        }
        
        if (record.getPublishDate() != null) {
            sql.SET("publish_date = #{publishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuthorState() != null) {
            sql.SET("author_state = #{authorState,jdbcType=TINYINT}");
        }
        
        if (record.getReplyState() != null) {
            sql.SET("reply_state = #{replyState,jdbcType=TINYINT}");
        }
        
        if (record.getReplyContent() != null) {
            sql.SET("reply_content = #{replyContent,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommentExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}