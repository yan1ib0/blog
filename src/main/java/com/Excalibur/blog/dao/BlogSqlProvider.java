package com.Excalibur.blog.dao;

import com.Excalibur.blog.entity.Blog;
import com.Excalibur.blog.entity.BlogExample.Criteria;
import com.Excalibur.blog.entity.BlogExample.Criterion;
import com.Excalibur.blog.entity.BlogExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class BlogSqlProvider {

    public String countByExample(BlogExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("blog_content");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Blog record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("blog_content");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getSummary() != null) {
            sql.VALUES("summary", "#{summary,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishDate() != null) {
            sql.VALUES("publish_date", "#{publishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getColumnId() != null) {
            sql.VALUES("column_id", "#{columnId,jdbcType=INTEGER}");
        }
        
        if (record.getViews() != null) {
            sql.VALUES("views", "#{views,jdbcType=INTEGER}");
        }
        
        if (record.getTags() != null) {
            sql.VALUES("tags", "#{tags,jdbcType=VARCHAR}");
        }
        
        if (record.getComments() != null) {
            sql.VALUES("comments", "#{comments,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogImg() != null) {
            sql.VALUES("blog_img", "#{blogImg,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogState() != null) {
            sql.VALUES("blog_state", "#{blogState,jdbcType=TINYINT}");
        }
        
        if (record.getAdmireState() != null) {
            sql.VALUES("admire_state", "#{admireState,jdbcType=TINYINT}");
        }
        
        if (record.getCommentsState() != null) {
            sql.VALUES("comments_state", "#{commentsState,jdbcType=TINYINT}");
        }
        
        if (record.getRecommendState() != null) {
            sql.VALUES("recommend_state", "#{recommendState,jdbcType=TINYINT}");
        }
        
        if (record.getReprintState() != null) {
            sql.VALUES("reprint_state", "#{reprintState,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARBINARY}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(BlogExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("title");
        sql.SELECT("summary");
        sql.SELECT("publish_date");
        sql.SELECT("column_id");
        sql.SELECT("views");
        sql.SELECT("tags");
        sql.SELECT("comments");
        sql.SELECT("blog_img");
        sql.SELECT("blog_state");
        sql.SELECT("admire_state");
        sql.SELECT("comments_state");
        sql.SELECT("recommend_state");
        sql.SELECT("reprint_state");
        sql.SELECT("create_time");
        sql.SELECT("content");
        sql.FROM("blog_content");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(BlogExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("title");
        sql.SELECT("summary");
        sql.SELECT("publish_date");
        sql.SELECT("column_id");
        sql.SELECT("views");
        sql.SELECT("tags");
        sql.SELECT("comments");
        sql.SELECT("blog_img");
        sql.SELECT("blog_state");
        sql.SELECT("admire_state");
        sql.SELECT("comments_state");
        sql.SELECT("recommend_state");
        sql.SELECT("reprint_state");
        sql.SELECT("create_time");
        sql.FROM("blog_content");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Blog record = (Blog) parameter.get("record");
        BlogExample example = (BlogExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("blog_content");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getSummary() != null) {
            sql.SET("summary = #{record.summary,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishDate() != null) {
            sql.SET("publish_date = #{record.publishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getColumnId() != null) {
            sql.SET("column_id = #{record.columnId,jdbcType=INTEGER}");
        }
        
        if (record.getViews() != null) {
            sql.SET("views = #{record.views,jdbcType=INTEGER}");
        }
        
        if (record.getTags() != null) {
            sql.SET("tags = #{record.tags,jdbcType=VARCHAR}");
        }
        
        if (record.getComments() != null) {
            sql.SET("comments = #{record.comments,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogImg() != null) {
            sql.SET("blog_img = #{record.blogImg,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogState() != null) {
            sql.SET("blog_state = #{record.blogState,jdbcType=TINYINT}");
        }
        
        if (record.getAdmireState() != null) {
            sql.SET("admire_state = #{record.admireState,jdbcType=TINYINT}");
        }
        
        if (record.getCommentsState() != null) {
            sql.SET("comments_state = #{record.commentsState,jdbcType=TINYINT}");
        }
        
        if (record.getRecommendState() != null) {
            sql.SET("recommend_state = #{record.recommendState,jdbcType=TINYINT}");
        }
        
        if (record.getReprintState() != null) {
            sql.SET("reprint_state = #{record.reprintState,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=LONGVARBINARY}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("blog_content");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("summary = #{record.summary,jdbcType=VARCHAR}");
        sql.SET("publish_date = #{record.publishDate,jdbcType=TIMESTAMP}");
        sql.SET("column_id = #{record.columnId,jdbcType=INTEGER}");
        sql.SET("views = #{record.views,jdbcType=INTEGER}");
        sql.SET("tags = #{record.tags,jdbcType=VARCHAR}");
        sql.SET("comments = #{record.comments,jdbcType=VARCHAR}");
        sql.SET("blog_img = #{record.blogImg,jdbcType=VARCHAR}");
        sql.SET("blog_state = #{record.blogState,jdbcType=TINYINT}");
        sql.SET("admire_state = #{record.admireState,jdbcType=TINYINT}");
        sql.SET("comments_state = #{record.commentsState,jdbcType=TINYINT}");
        sql.SET("recommend_state = #{record.recommendState,jdbcType=TINYINT}");
        sql.SET("reprint_state = #{record.reprintState,jdbcType=TINYINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("content = #{record.content,jdbcType=LONGVARBINARY}");
        
        BlogExample example = (BlogExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("blog_content");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("summary = #{record.summary,jdbcType=VARCHAR}");
        sql.SET("publish_date = #{record.publishDate,jdbcType=TIMESTAMP}");
        sql.SET("column_id = #{record.columnId,jdbcType=INTEGER}");
        sql.SET("views = #{record.views,jdbcType=INTEGER}");
        sql.SET("tags = #{record.tags,jdbcType=VARCHAR}");
        sql.SET("comments = #{record.comments,jdbcType=VARCHAR}");
        sql.SET("blog_img = #{record.blogImg,jdbcType=VARCHAR}");
        sql.SET("blog_state = #{record.blogState,jdbcType=TINYINT}");
        sql.SET("admire_state = #{record.admireState,jdbcType=TINYINT}");
        sql.SET("comments_state = #{record.commentsState,jdbcType=TINYINT}");
        sql.SET("recommend_state = #{record.recommendState,jdbcType=TINYINT}");
        sql.SET("reprint_state = #{record.reprintState,jdbcType=TINYINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        BlogExample example = (BlogExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Blog record) {
        SQL sql = new SQL();
        sql.UPDATE("blog_content");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getSummary() != null) {
            sql.SET("summary = #{summary,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishDate() != null) {
            sql.SET("publish_date = #{publishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getColumnId() != null) {
            sql.SET("column_id = #{columnId,jdbcType=INTEGER}");
        }
        
        if (record.getViews() != null) {
            sql.SET("views = #{views,jdbcType=INTEGER}");
        }
        
        if (record.getTags() != null) {
            sql.SET("tags = #{tags,jdbcType=VARCHAR}");
        }
        
        if (record.getComments() != null) {
            sql.SET("comments = #{comments,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogImg() != null) {
            sql.SET("blog_img = #{blogImg,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogState() != null) {
            sql.SET("blog_state = #{blogState,jdbcType=TINYINT}");
        }
        
        if (record.getAdmireState() != null) {
            sql.SET("admire_state = #{admireState,jdbcType=TINYINT}");
        }
        
        if (record.getCommentsState() != null) {
            sql.SET("comments_state = #{commentsState,jdbcType=TINYINT}");
        }
        
        if (record.getRecommendState() != null) {
            sql.SET("recommend_state = #{recommendState,jdbcType=TINYINT}");
        }
        
        if (record.getReprintState() != null) {
            sql.SET("reprint_state = #{reprintState,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARBINARY}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BlogExample example, boolean includeExamplePhrase) {
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